package org.bouncycastle.pqc.jcajce.provider;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

/* JADX INFO: loaded from: classes42.dex */
public class BouncyCastlePQCProvider extends Provider implements ConfigurableProvider {
    private static final String[] ALGORITHMS = null;
    private static final String ALGORITHM_PACKAGE = "org.bouncycastle.pqc.jcajce.provider.";
    public static final ProviderConfiguration CONFIGURATION = null;
    public static String PROVIDER_NAME = "BCPQC";
    private static String info = "BouncyCastle Post-Quantum Security Provider v1.67";
    private static final Map keyInfoConverters = null;

    static {
        keyInfoConverters = new HashMap();
        ALGORITHMS = new String[]{"Rainbow", "McEliece", "SPHINCS", "LMS", "NH", "XMSS", "QTESLA"};
    }

    public BouncyCastlePQCProvider() {
        super(PROVIDER_NAME, 1.67d, info);
        AccessController.doPrivileged(new AnonymousClass1(this));
    }

    public static /* synthetic */ void access$000(BouncyCastlePQCProvider r100) {
        r100.setup();
    }

    private static AsymmetricKeyInfoConverter getAsymmetricKeyInfoConverter(ASN1ObjectIdentifier r100) {
        Map r101 = keyInfoConverters;
        monitor-enter(r101);
        AsymmetricKeyInfoConverter r102 = (AsymmetricKeyInfoConverter) r101.get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static PrivateKey getPrivateKey(PrivateKeyInfo r100) throws IOException {
        AsymmetricKeyInfoConverter r101 = getAsymmetricKeyInfoConverter(r100.getPrivateKeyAlgorithm().getAlgorithm());
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.generatePrivate(r100);
    }

    public static PublicKey getPublicKey(SubjectPublicKeyInfo r100) throws IOException {
        AsymmetricKeyInfoConverter r101 = getAsymmetricKeyInfoConverter(r100.getAlgorithm().getAlgorithm());
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.generatePublic(r100);
    }

    private void loadAlgorithms(String r100, String[] r101) {
        int r102 = 0;
    L4:
        if (r102 == r101.length) goto L13;
        Class r103 = loadClass(BouncyCastlePQCProvider.class, r100 + r101[r102] + "$Mappings");
        if (r103 == null) goto L12;
        ((AlgorithmProvider) r103.newInstance()).configure(this);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        throw new InternalError("cannot create instance of " + r100 + r101[r102] + "$Mappings : " + e);
    L12:
        r102 = r102 + 1;
        goto L4
    }

    public static Class loadClass(Class r100, final String r101) {
        ClassLoader r102 = r100.getClassLoader();     // Catch: ClassNotFoundException -> L8
        if (r102 == null) goto L7;
        return INVOKEVIRTUAL_org_bouncycastle_pqc_jcajce_provider_BouncyCastlePQCProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r102, r101);
    L7:
        return (Class) AccessController.doPrivileged(new AnonymousClass2(r101));
    L8:
        return null;
    }

    private void setup() {
        loadAlgorithms(ALGORITHM_PACKAGE, ALGORITHMS);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addAlgorithm(String r100, String r101) {
        if (containsKey(r100) == true) goto L7;
        put(r100, r101);
        return;
    L7:
        throw new IllegalStateException("duplicate provider key (" + r100 + ") found");
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addAlgorithm(String r100, ASN1ObjectIdentifier r101, String r102) {
        if (containsKey(r100 + "." + r102) == false) goto L7;
        addAlgorithm(r100 + "." + r101, r102);
        addAlgorithm(r100 + ".OID." + r101, r102);
        return;
    L7:
        throw new IllegalStateException("primary key (" + r100 + "." + r102 + ") not found");
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addAttributes(String r100, Map<String, String> r101) {
        Iterator<String> r102 = r101.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        String r104 = r100 + " " + r103;
        if (containsKey(r104) == true) goto L9;
        put(r104, r101.get(r103));
        goto L4
    L9:
        throw new IllegalStateException("duplicate provider attribute key (" + r104 + ") found");
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void addKeyInfoConverter(ASN1ObjectIdentifier r100, AsymmetricKeyInfoConverter r101) {
        Map r102 = keyInfoConverters;
        monitor-enter(r102);
        r102.put(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public AsymmetricKeyInfoConverter getKeyInfoConverter(ASN1ObjectIdentifier r100) {
        return (AsymmetricKeyInfoConverter) keyInfoConverters.get(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public boolean hasAlgorithm(String r100, String r101) {
        if (containsKey(r100 + "." + r101) == false) goto L5;
    L8:
        return true;
    L5:
        if (containsKey("Alg.Alias." + r100 + "." + r101) == true) goto L8;
        return false;
    }

    @Override // org.bouncycastle.jcajce.provider.config.ConfigurableProvider
    public void setParameter(String r100, Object r101) {
        ProviderConfiguration r102 = CONFIGURATION;
        monitor-enter(r102);
        monitor-exit(r102);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_org_bouncycastle_pqc_jcajce_provider_BouncyCastlePQCProvider_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }
}
