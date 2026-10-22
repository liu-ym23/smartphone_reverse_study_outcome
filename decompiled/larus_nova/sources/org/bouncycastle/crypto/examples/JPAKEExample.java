package org.bouncycastle.crypto.examples;

import com.alipay.sdk.m.u.i;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.agreement.jpake.JPAKEParticipant;
import org.bouncycastle.crypto.agreement.jpake.JPAKEPrimeOrderGroup;
import org.bouncycastle.crypto.agreement.jpake.JPAKEPrimeOrderGroups;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound1Payload;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound2Payload;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound3Payload;
import org.bouncycastle.crypto.digests.SHA256Digest;

/* JADX INFO: loaded from: classes42.dex */
public class JPAKEExample {
    public JPAKEExample() {
    }

    private static BigInteger deriveSessionKey(BigInteger r100) {
        SHA256Digest r101 = new SHA256Digest();
        byte[] r102 = r100.toByteArray();
        byte[] r103 = new byte[r101.getDigestSize()];
        r101.update(r102, 0, r102.length);
        r101.doFinal(r103, 0);
        return new BigInteger(r103);
    }

    public static void main(String[] r110) throws CryptoException {
        JPAKEPrimeOrderGroup r111 = JPAKEPrimeOrderGroups.NIST_3072;
        BigInteger r100 = r111.getP();
        BigInteger r101 = r111.getQ();
        BigInteger r102 = r111.getG();
        System.out.println("********* Initialization **********");
        System.out.println("Public parameters for the cyclic group:");
        System.out.println("p (" + r100.bitLength() + " bits): " + r100.toString(16));
        System.out.println("q (" + r101.bitLength() + " bits): " + r101.toString(16));
        System.out.println("g (" + r100.bitLength() + " bits): " + r102.toString(16));
        PrintStream r103 = System.out;
        StringBuilder r104 = new StringBuilder("p mod q = ");
        r104.append(r100.mod(r101).toString(16));
        r103.println(r104.toString());
        System.out.println("g^{q} mod p = " + r102.modPow(r101, r100).toString(16));
        System.out.println("");
        System.out.println("(Secret passwords used by Alice and Bob: \"password\" and \"password\")\n");
        SHA256Digest r105 = new SHA256Digest();
        SecureRandom r106 = new SecureRandom();
        JPAKEParticipant r112 = new JPAKEParticipant("alice", "password".toCharArray(), r111, r105, r106);
        JPAKEParticipant r113 = new JPAKEParticipant("bob", "password".toCharArray(), r111, r105, r106);
        JPAKERound1Payload r114 = r112.createRound1PayloadToSend();
        JPAKERound1Payload r107 = r113.createRound1PayloadToSend();
        System.out.println("************ Round 1 **************");
        System.out.println("Alice sends to Bob: ");
        System.out.println("g^{x1}=" + r114.getGx1().toString(16));
        System.out.println("g^{x2}=" + r114.getGx2().toString(16));
        System.out.println("KP{x1}={" + r114.getKnowledgeProofForX1()[0].toString(16) + "};{" + r114.getKnowledgeProofForX1()[1].toString(16) + i.f25855d);
        System.out.println("KP{x2}={" + r114.getKnowledgeProofForX2()[0].toString(16) + "};{" + r114.getKnowledgeProofForX2()[1].toString(16) + i.f25855d);
        System.out.println("");
        System.out.println("Bob sends to Alice: ");
        System.out.println("g^{x3}=" + r107.getGx1().toString(16));
        System.out.println("g^{x4}=" + r107.getGx2().toString(16));
        System.out.println("KP{x3}={" + r107.getKnowledgeProofForX1()[0].toString(16) + "};{" + r107.getKnowledgeProofForX1()[1].toString(16) + i.f25855d);
        System.out.println("KP{x4}={" + r107.getKnowledgeProofForX2()[0].toString(16) + "};{" + r107.getKnowledgeProofForX2()[1].toString(16) + i.f25855d);
        System.out.println("");
        r112.validateRound1PayloadReceived(r107);
        System.out.println("Alice checks g^{x4}!=1: OK");
        System.out.println("Alice checks KP{x3}: OK");
        System.out.println("Alice checks KP{x4}: OK");
        System.out.println("");
        r113.validateRound1PayloadReceived(r114);
        System.out.println("Bob checks g^{x2}!=1: OK");
        System.out.println("Bob checks KP{x1},: OK");
        System.out.println("Bob checks KP{x2},: OK");
        System.out.println("");
        JPAKERound2Payload r115 = r112.createRound2PayloadToSend();
        JPAKERound2Payload r108 = r113.createRound2PayloadToSend();
        System.out.println("************ Round 2 **************");
        System.out.println("Alice sends to Bob: ");
        System.out.println("A=" + r115.getA().toString(16));
        System.out.println("KP{x2*s}={" + r115.getKnowledgeProofForX2s()[0].toString(16) + "},{" + r115.getKnowledgeProofForX2s()[1].toString(16) + i.f25855d);
        System.out.println("");
        System.out.println("Bob sends to Alice");
        System.out.println("B=" + r108.getA().toString(16));
        System.out.println("KP{x4*s}={" + r108.getKnowledgeProofForX2s()[0].toString(16) + "},{" + r108.getKnowledgeProofForX2s()[1].toString(16) + i.f25855d);
        System.out.println("");
        r112.validateRound2PayloadReceived(r108);
        System.out.println("Alice checks KP{x4*s}: OK\n");
        r113.validateRound2PayloadReceived(r115);
        System.out.println("Bob checks KP{x2*s}: OK\n");
        BigInteger r116 = r112.calculateKeyingMaterial();
        BigInteger r109 = r113.calculateKeyingMaterial();
        System.out.println("********* After round 2 ***********");
        System.out.println("Alice computes key material \t K=" + r116.toString(16));
        System.out.println("Bob computes key material \t K=" + r109.toString(16));
        System.out.println();
        deriveSessionKey(r116);
        deriveSessionKey(r109);
        JPAKERound3Payload r117 = r112.createRound3PayloadToSend(r116);
        JPAKERound3Payload r118 = r113.createRound3PayloadToSend(r109);
        System.out.println("************ Round 3 **************");
        System.out.println("Alice sends to Bob: ");
        System.out.println("MacTag=" + r117.getMacTag().toString(16));
        System.out.println("");
        System.out.println("Bob sends to Alice: ");
        System.out.println("MacTag=" + r118.getMacTag().toString(16));
        System.out.println("");
        r112.validateRound3PayloadReceived(r118, r116);
        System.out.println("Alice checks MacTag: OK\n");
        r113.validateRound3PayloadReceived(r117, r109);
        System.out.println("Bob checks MacTag: OK\n");
        System.out.println();
        System.out.println("MacTags validated, therefore the keying material matches.");
    }
}
