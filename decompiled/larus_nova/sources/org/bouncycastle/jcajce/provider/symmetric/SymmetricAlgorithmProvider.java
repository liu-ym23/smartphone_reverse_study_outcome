package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

/* JADX INFO: loaded from: classes42.dex */
abstract class SymmetricAlgorithmProvider extends AlgorithmProvider {
    public SymmetricAlgorithmProvider() {
    }

    public void addCMacAlgorithm(ConfigurableProvider r100, String r101, String r102, String r103) {
        r100.addAlgorithm("Mac." + r101 + "-CMAC", r102);
        r100.addAlgorithm("Alg.Alias.Mac." + r101 + "CMAC", r101 + "-CMAC");
        r100.addAlgorithm("KeyGenerator." + r101 + "-CMAC", r103);
        r100.addAlgorithm("Alg.Alias.KeyGenerator." + r101 + "CMAC", r101 + "-CMAC");
    }

    public void addGMacAlgorithm(ConfigurableProvider r100, String r101, String r102, String r103) {
        r100.addAlgorithm("Mac." + r101 + "-GMAC", r102);
        r100.addAlgorithm("Alg.Alias.Mac." + r101 + "GMAC", r101 + "-GMAC");
        r100.addAlgorithm("KeyGenerator." + r101 + "-GMAC", r103);
        r100.addAlgorithm("Alg.Alias.KeyGenerator." + r101 + "GMAC", r101 + "-GMAC");
    }

    public void addPoly1305Algorithm(ConfigurableProvider r100, String r101, String r102, String r103) {
        r100.addAlgorithm("Mac.POLY1305-" + r101, r102);
        r100.addAlgorithm("Alg.Alias.Mac.POLY1305" + r101, "POLY1305-" + r101);
        r100.addAlgorithm("KeyGenerator.POLY1305-" + r101, r103);
        r100.addAlgorithm("Alg.Alias.KeyGenerator.POLY1305" + r101, "POLY1305-" + r101);
    }
}
