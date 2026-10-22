package com.google.protobuf;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class ExtensionRegistryLite {
    static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = null;
    static final String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
    private static volatile boolean eagerlyParseMessageSets;
    private static final Class<?> extensionClass = null;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    public static final class ObjectIntPair {
        private final int number;
        private final Object object;

        public int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof ObjectIntPair) == true) goto L5;
            return false;
        L5:
            ObjectIntPair r101 = (ObjectIntPair) r100;
            if (this.object == r101.object) goto L8;
            return false;
        L8:
            if (this.number != r101.number) goto L12;
            return true;
        L12:
            return false;
        }

        public ObjectIntPair(Object r100, int r101) {
            this.object = r100;
            this.number = r101;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static Class<?> resolveExtensionClass() {
        return INVOKESTATIC_com_google_protobuf_ExtensionRegistryLite_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(EXTENSION_CLASS_NAME);
    L4:
        return null;
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    static {
        extensionClass = resolveExtensionClass();
        EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
    }

    public ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        return ExtensionRegistryFactory.createEmpty();
    }

    public static ExtensionRegistryLite newInstance() {
        return ExtensionRegistryFactory.create();
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public ExtensionRegistryLite(ExtensionRegistryLite r100) {
        if (r100 != EMPTY_REGISTRY_LITE) goto L5;
        this.extensionsByNumber = Collections.emptyMap();
        return;
    L5:
        this.extensionsByNumber = Collections.unmodifiableMap(r100.extensionsByNumber);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_google_protobuf_ExtensionRegistryLite_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void setEagerlyParseMessageSets(boolean r100) {
        eagerlyParseMessageSets = r100;
    }

    public final void add(ExtensionLite<?, ?> r100) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(r100.getClass()) == false) goto L6;
        add((GeneratedMessageLite.GeneratedExtension) r100);
    L6:
        if (ExtensionRegistryFactory.isFullRegistry(this) == true) goto L14;
        return;
    L14:
        getClass().getMethod("add", new Class[]{extensionClass}).invoke(this, new Object[]{r100});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[]{r100}), e);
    }

    public ExtensionRegistryLite(boolean r100) {
        this.extensionsByNumber = Collections.emptyMap();
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> r100) {
        this.extensionsByNumber.put(new ObjectIntPair(r100.getContainingTypeDefaultInstance(), r100.getNumber()), r100);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType r100, int r101) {
        return (GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(r100, r101));
    }
}
