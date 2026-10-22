package org.bouncycastle.crypto.generators;

import com.ss.bduploader.BDAbstractUpload;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.bduploader.UploadKeys;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.VideoRef;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import org.bouncycastle.crypto.params.NaccacheSternKeyParameters;
import org.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = null;
    private static int[] smallPrimes;
    private NaccacheSternKeyGenerationParameters param;

    static {
        smallPrimes = new int[]{3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 199, 211, 223, VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL, 229, 233, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X, 241, 251, 257, MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 307, 311, 313, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, 331, 337, 347, 349, 353, 359, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME, 373, MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS, MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, 401, 409, 419, 421, 431, BDAbstractUpload.KeyIsRetryStatesDir, UploadKeys.KeyIsEnd2EndEncryptionOption, UploadKeys.KeyIsGetVideoMeta, BDVideoUploaderBase.KeyIsDynamicSliceNormalSize, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_DNS_TIME, 461, MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_WIDTH, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_ERR_NO_VIDEO, 479, TTVideoEngineInterface.PLAYER_OPTION_SET_NETSPEED_LEVEL, TTVideoEngineInterface.PLAYER_OPTION_PREPARE_CACHE_MS, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_BARRAGE_MASK, 503, 509, 521, 523, 541, 547, 557};
        ONE = BigInteger.valueOf(1);
    }

    public NaccacheSternKeyPairGenerator() {
    }

    private static Vector findFirstPrimes(int r100) {
        Vector r101 = new Vector(r100);
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101.addElement(BigInteger.valueOf(smallPrimes[r102]));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    private static BigInteger generatePrime(int r100, int r101, SecureRandom r102) {
    L2:
        BigInteger r103 = BigIntegers.createRandomPrime(r100, r101, r102);
        if (r103.bitLength() != r100) goto L2;
        return r103;
    }

    private static int getInt(SecureRandom r100, int r101) {
        if (((-r101) & r101) == r101) goto L5;
    L6:
        int r102 = r100.nextInt() & Integer.MAX_VALUE;
        int r103 = r102 % r101;
        if (((r102 - r103) + (r101 - 1)) < 0) goto L6;
        return r103;
    L5:
        return (int) ((((long) r101) * ((long) (r100.nextInt() & Integer.MAX_VALUE))) >> 31);
    }

    private static Vector permuteList(Vector r100, SecureRandom r101) {
        Vector r102 = new Vector();
        Vector r103 = new Vector();
        int r104 = 0;
    L4:
        if (r104 >= r100.size()) goto L6;
        r103.addElement(r100.elementAt(r104));
        r104 = r104 + 1;
        goto L4
    L6:
        r102.addElement(r103.elementAt(0));
    L7:
        r103.removeElementAt(0);
        if (r103.size() == 0) goto L10;
        r102.insertElementAt(r103.elementAt(0), getInt(r101, r102.size() + 1));
        goto L7
    L10:
        return r102;
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        int r100 = this.param.getStrength();
        SecureRandom r101 = this.param.getRandom();
        int r102 = this.param.getCertainty();
        boolean r103 = this.param.isDebug();
        if (r103 == false) goto L5;
        System.out.println("Fetching first " + this.param.getCntSmallPrimes() + " primes.");
    L5:
        Vector r110 = permuteList(findFirstPrimes(this.param.getCntSmallPrimes()), r101);
        BigInteger r104 = ONE;
        BigInteger r105 = r104;
        int r106 = 0;
    L7:
        if (r106 >= (r110.size() / 2)) goto L9;
        r105 = r105.multiply((BigInteger) r110.elementAt(r106));
        r106 = r106 + 1;
        goto L7
    L9:
        int r107 = r110.size() / 2;
    L11:
        if (r107 >= r110.size()) goto L13;
        r104 = r104.multiply((BigInteger) r110.elementAt(r107));
        r107 = r107 + 1;
        goto L11
    L13:
        BigInteger r108 = r105.multiply(r104);
        int r109 = (((r100 - r108.bitLength()) - 48) / 2) + 1;
        BigInteger r111 = generatePrime(r109, r102, r101);
        BigInteger r112 = generatePrime(r109, r102, r101);
        if (r103 == false) goto L16;
        System.out.println("generating p and q");
    L16:
        BigInteger r113 = r111.multiply(r105).shiftLeft(1);
        BigInteger r114 = r112.multiply(r104).shiftLeft(1);
        long r115 = 0;
    L17:
        long r116 = r115 + 1;
        BigInteger r117 = generatePrime(24, r102, r101);
        BigInteger r118 = r117.multiply(r113).add(ONE);
        if (r118.isProbablePrime(r102) == true) goto L21;
        BigInteger r210 = r114;
        BigInteger r211 = r113;
    L33:
        r115 = r116;
        r114 = r210;
        r113 = r211;
    L21:
        BigInteger r119 = generatePrime(24, r102, r101);
        if (r117.equals(r119) == true) goto L21;
        BigInteger r120 = r119.multiply(r114);
        r210 = r114;
        BigInteger r121 = ONE;
        BigInteger r122 = r120.add(r121);
        if (r122.isProbablePrime(r102) == true) goto L26;
        r114 = r210;
        goto L21
    L26:
        r211 = r113;
        if (r108.gcd(r117.multiply(r119)).equals(r121) == false) goto L33;
        if (r118.multiply(r122).bitLength() >= r100) goto L34;
        if (r103 == false) goto L33;
        System.out.println("key size too small. Should be " + r100 + " but is actually " + r118.multiply(r122).bitLength());
        goto L33
    L34:
        BigInteger r212 = r112;
        if (r103 == false) goto L38;
        System.out.println("needed " + r116 + " tries to generate p and q.");
    L38:
        BigInteger r123 = r118.multiply(r122);
        BigInteger r124 = r118.subtract(r121).multiply(r122.subtract(r121));
        if (r103 == false) goto L41;
        System.out.println("generating g");
    L41:
        long r125 = 0;
    L42:
        Vector r126 = new Vector();
        BigInteger r213 = r118;
        BigInteger r214 = r122;
        int r127 = 0;
    L44:
        if (r127 == r110.size()) goto L50;
        BigInteger r128 = r124.divide((BigInteger) r110.elementAt(r127));
    L46:
        long r129 = r125 + 1;
        BigInteger r130 = BigIntegers.createRandomPrime(r100, r102, r101);
        int r215 = r100;
        if (r130.modPow(r128, r123).equals(ONE) == false) goto L49;
        r125 = r129;
        r100 = r215;
        goto L46
    L49:
        r126.addElement(r130);
        r127 = r127 + 1;
        r125 = r129;
        r100 = r215;
        goto L44
    L50:
        int r216 = r100;
        BigInteger r131 = ONE;
        int r132 = 0;
    L52:
        if (r132 >= r110.size()) goto L54;
        r131 = r131.multiply(((BigInteger) r126.elementAt(r132)).modPow(r108.divide((BigInteger) r110.elementAt(r132)), r123)).mod(r123);
        r132 = r132 + 1;
        r101 = r101;
        goto L52
    L54:
        SecureRandom r217 = r101;
        int r133 = 0;
    L56:
        if (r133 >= r110.size()) goto L63;
        if (r131.modPow(r124.divide((BigInteger) r110.elementAt(r133)), r123).equals(ONE) == true) goto L59;
        r133 = r133 + 1;
        goto L56
    L59:
        if (r103 == false) goto L61;
        System.out.println("g has order phi(n)/" + r110.elementAt(r133) + "\n g: " + r131);
    L61:
        boolean r134 = true;
    L64:
        if (r134 == false) goto L67;
    L65:
        BigInteger r135 = r212;
        BigInteger r136 = r111;
    L89:
        r111 = r136;
        r102 = r102;
        r122 = r214;
        r118 = r213;
        r100 = r216;
        r101 = r217;
        r212 = r135;
        goto L42
    L67:
        BigInteger r137 = r131.modPow(r124.divide(BigInteger.valueOf(4)), r123);
        BigInteger r138 = ONE;
        if (r137.equals(r138) == false) goto L73;
        if (r103 == false) goto L65;
        PrintStream r139 = System.out;
        StringBuilder r140 = new StringBuilder("g has order phi(n)/4\n g:");
    L71:
        r140.append(r131);
        r139.println(r140.toString());
        goto L65
    L73:
        if (r131.modPow(r124.divide(r117), r123).equals(r138) == false) goto L77;
        if (r103 == false) goto L65;
        r139 = System.out;
        r140 = new StringBuilder("g has order phi(n)/p'\n g: ");
        goto L71
    L77:
        if (r131.modPow(r124.divide(r119), r123).equals(r138) == false) goto L80;
        if (r103 == false) goto L65;
        r139 = System.out;
        r140 = new StringBuilder("g has order phi(n)/q'\n g: ");
        goto L71
    L80:
        r136 = r111;
        if (r131.modPow(r124.divide(r136), r123).equals(r138) == false) goto L85;
        if (r103 == false) goto L84;
        System.out.println("g has order phi(n)/a\n g: " + r131);
    L84:
        r135 = r212;
        goto L89
    L85:
        r135 = r212;
        if (r131.modPow(r124.divide(r135), r123).equals(r138) == false) goto L90;
        if (r103 == false) goto L89;
        System.out.println("g has order phi(n)/b\n g: " + r131);
        goto L89
    L90:
        if (r103 == false) goto L93;
        System.out.println("needed " + r125 + " tries to generate g");
        System.out.println();
        System.out.println("found new NaccacheStern cipher variables:");
        System.out.println("smallPrimes: " + r110);
        System.out.println("sigma:...... " + r108 + " (" + r108.bitLength() + " bits)");
        PrintStream r141 = System.out;
        StringBuilder r142 = new StringBuilder("a:.......... ");
        r142.append(r136);
        r141.println(r142.toString());
        System.out.println("b:.......... " + r135);
        System.out.println("p':......... " + r117);
        System.out.println("q':......... " + r119);
        System.out.println("p:.......... " + r213);
        System.out.println("q:.......... " + r214);
        System.out.println("n:.......... " + r123);
        System.out.println("phi(n):..... " + r124);
        System.out.println("g:.......... " + r131);
        System.out.println();
    L93:
        return new AsymmetricCipherKeyPair(new NaccacheSternKeyParameters(false, r131, r123, r108.bitLength()), new NaccacheSternPrivateKeyParameters(r131, r123, r108.bitLength(), r110, r124));
    L63:
        r134 = false;
        goto L64
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        this.param = (NaccacheSternKeyGenerationParameters) r100;
    }
}
