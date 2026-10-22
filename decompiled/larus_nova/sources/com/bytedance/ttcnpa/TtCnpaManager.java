package com.bytedance.ttcnpa;

import com.bytedance.pia.core.metrics.ErrorType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tt_cnpa_sdk.proto.FuncParamsX6cbd423519d6718d;
import tt_cnpa_sdk.proto.FuncParamsX81df78889df4faba;
import tt_cnpa_sdk.proto.FuncParamsX9d78a9352267336e;
import tt_cnpa_sdk.proto.FuncReturnXb2c4f98239e616de;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0014J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0082 J\u001b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u001b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u001b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u001b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0082 J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0082 ¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ttcnpa/TtCnpaManager;", "Lcom/bytedance/ttcnpa/RustArcClass;", "Lcom/bytedance/ttcnpa/TtCnpaManagerInterface;", "", "pointer", "", "MoltenFfiNativeInitManagerX8093294051852316572", "Ljava/nio/ByteBuffer;", "params", "MoltenFfiNativeWriteManifestX5170153001473729005", "MoltenFfiNativeWriteManifestManuallyX4220966312823523095", "MoltenFfiNativeWriteJsonManifestManuallyX1940272386043592416", "MoltenFfiNativeWriteManifestToBytesX602974861927357309", "MoltenFfiNativeWirteManifestManuallyToBytesX5923526728918411534", "MoltenFfiNativeWirteJsonManifestManuallyToBytesX7764685443243576590", "MoltenFfiNativeReadManifestX4141702152160902466", "MoltenFfiNativeReadManifestFromBytesX638856986908017137", "MoltenFfiNativeReadManifestFromBytesWithExtX2619763900196143802", "MoltenFfiNativeReadExifManifestFromFileX5749297927889657481", "MoltenFfiNativeReadExifManifestFromBytesX6809661158390140572", "Companion", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
public class TtCnpaManager extends RustArcClass implements TtCnpaManagerInterface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f271044d = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ttcnpa/TtCnpaManager$Companion;", "", "<init>", "()V", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        f271044d = new Companion(0);
    }

    private final native String MoltenFfiNativeInitManagerX8093294051852316572(long r100) throws Exception;

    private final native ByteBuffer MoltenFfiNativeReadExifManifestFromBytesX6809661158390140572(long r100, ByteBuffer r101) throws Exception;

    private final native ByteBuffer MoltenFfiNativeReadExifManifestFromFileX5749297927889657481(long r100, ByteBuffer r101) throws Exception;

    private final native ByteBuffer MoltenFfiNativeReadManifestFromBytesWithExtX2619763900196143802(long r100, ByteBuffer r101) throws Exception;

    private final native ByteBuffer MoltenFfiNativeReadManifestFromBytesX638856986908017137(long r100, ByteBuffer r101) throws Exception;

    private final native ByteBuffer MoltenFfiNativeReadManifestX4141702152160902466(long r100, ByteBuffer r101) throws Exception;

    private final native ByteBuffer MoltenFfiNativeWirteJsonManifestManuallyToBytesX7764685443243576590(long r100, ByteBuffer r101) throws Exception;

    private final native ByteBuffer MoltenFfiNativeWirteManifestManuallyToBytesX5923526728918411534(long r100, ByteBuffer r101) throws Exception;

    private final native ByteBuffer MoltenFfiNativeWriteJsonManifestManuallyX1940272386043592416(long r100, ByteBuffer r101) throws Exception;

    private final native ByteBuffer MoltenFfiNativeWriteManifestManuallyX4220966312823523095(long r100, ByteBuffer r101) throws Exception;

    private final native ByteBuffer MoltenFfiNativeWriteManifestToBytesX602974861927357309(long r100, ByteBuffer r101) throws Exception;

    private final native ByteBuffer MoltenFfiNativeWriteManifestX5170153001473729005(long r100, ByteBuffer r101) throws Exception;

    @JvmStatic
    private static final native void molten_ffi_tt_cnpa_sdk_TtCnpaManager_free(long r100);

    @Override // com.bytedance.ttcnpa.RustArcClass
    public final void a() {
        ArcHandle r100 = this.f271034a;
        if ((r100 instanceof ArcHandle.LongHandle) == false) goto L6;
        Companion r101 = f271044d;
        long r102 = ((ArcHandle.LongHandle) r100).f271030a;
        r101.getClass();
        b(r102);
        return;
    }

    public final void c() {
        ArcHandle r100 = this.f271034a;
        if ((r100 instanceof ArcHandle.LongHandle) == false) goto L7;
        MoltenFfiNativeInitManagerX8093294051852316572(((ArcHandle.LongHandle) r100).f271030a);
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    public TtCnpaManager(ArcHandle.LongHandle r100) {
        Intrinsics.checkNotNullParameter(r100, "pointer");
        super(r100);
    }

    public static final /* synthetic */ void b(long r100) {
        molten_ffi_tt_cnpa_sdk_TtCnpaManager_free(r100);
    }

    public final TtCnpaResult d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        FuncParamsX6cbd423519d6718d r101 = new FuncParamsX6cbd423519d6718d(r100, Boolean.FALSE);
        ByteBuffer r102 = ByteBuffer.allocateDirect(FuncParamsX6cbd423519d6718d.ADAPTER.encodedSize(r101));
        r101.encode(new ByteBufferOutputStream(r102));
    L3:
        long r103 = this.f271036c.get();
        if (r103 == 0) goto L37;
        if (r103 == Long.MAX_VALUE) goto L35;
        if (this.f271036c.compareAndSet(r103, 1 + r103) == false) goto L3;
        ArcHandle r104 = this.f271034a;     // Catch: Throwable -> L29
        if ((r104 instanceof ArcHandle.LongHandle) == false) goto L28;
        ByteBuffer r105 = MoltenFfiNativeReadManifestX4141702152160902466(((ArcHandle.LongHandle) r104).f271030a, r102);     // Catch: Throwable -> L29
        if (this.f271036c.decrementAndGet() != 0) goto L16;
        a();
    L16:
        if (r105 != null) goto L18;
        InputStream r106 = new ByteArrayInputStream(new byte[0]);
    L38:
        tt_cnpa_sdk.proto.TtCnpaResult r107 = FuncReturnXb2c4f98239e616de.ADAPTER.decode(r106).ret;     // Catch: Exception -> L21
    L23:
        if (r105 == null) goto L26;
        MoltenFfiTtCnpaSdk.f271033a.getClass();
        MoltenFfiTtCnpaSdk.freeNativeMemory(r105);
    L26:
        return Tt_cnpa_sdkKt.b(r107);
    L21:
        e = move-exception;
        e.printStackTrace();
        r107 = FuncReturnXb2c4f98239e616de.ADAPTER.decode(new ByteArrayInputStream(new byte[0])).ret;
        goto L23
    L18:
        Intrinsics.checkNotNull(r105);
        r106 = new ByteBufferInputStream(r105);
        goto L38
    L28:
        throw new IllegalStateException(getClass().getSimpleName() + " pointer type mismatch(long expected)");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        if (this.f271036c.decrementAndGet() != 0) goto L33;
        a();
    L33:
        throw th;
    L35:
        throw new IllegalStateException(getClass().getSimpleName().concat(" call counter would overflow"));
    L37:
        throw new IllegalStateException(getClass().getSimpleName().concat(" object has already been destroyed"));
    }

    public final TtCnpaResult f(String r100, String r101, TtCnpaManifest r102) {
        Intrinsics.checkNotNullParameter(r100, "inputPath");
        Intrinsics.checkNotNullParameter(r101, "outputPath");
        Intrinsics.checkNotNullParameter(r102, ErrorType.MANIFEST);
        FuncParamsX9d78a9352267336e r103 = new FuncParamsX9d78a9352267336e(r100, r101, r102.into());
        ByteBuffer r104 = ByteBuffer.allocateDirect(FuncParamsX9d78a9352267336e.ADAPTER.encodedSize(r103));
        r103.encode(new ByteBufferOutputStream(r104));
    L3:
        long r105 = this.f271036c.get();
        if (r105 == 0) goto L37;
        if (r105 == Long.MAX_VALUE) goto L35;
        if (this.f271036c.compareAndSet(r105, 1 + r105) == false) goto L3;
        ArcHandle r106 = this.f271034a;     // Catch: Throwable -> L29
        if ((r106 instanceof ArcHandle.LongHandle) == false) goto L28;
        ByteBuffer r107 = MoltenFfiNativeWriteManifestManuallyX4220966312823523095(((ArcHandle.LongHandle) r106).f271030a, r104);     // Catch: Throwable -> L29
        if (this.f271036c.decrementAndGet() != 0) goto L16;
        a();
    L16:
        if (r107 != null) goto L18;
        InputStream r108 = new ByteArrayInputStream(new byte[0]);
    L39:
        tt_cnpa_sdk.proto.TtCnpaResult r109 = FuncReturnXb2c4f98239e616de.ADAPTER.decode(r108).ret;     // Catch: Exception -> L21
    L23:
        if (r107 == null) goto L26;
        MoltenFfiTtCnpaSdk.f271033a.getClass();
        MoltenFfiTtCnpaSdk.freeNativeMemory(r107);
    L26:
        return Tt_cnpa_sdkKt.b(r109);
    L21:
        e = move-exception;
        e.printStackTrace();
        r109 = FuncReturnXb2c4f98239e616de.ADAPTER.decode(new ByteArrayInputStream(new byte[0])).ret;
        goto L23
    L18:
        Intrinsics.checkNotNull(r107);
        r108 = new ByteBufferInputStream(r107);
        goto L39
    L28:
        throw new IllegalStateException(getClass().getSimpleName() + " pointer type mismatch(long expected)");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        if (this.f271036c.decrementAndGet() != 0) goto L33;
        a();
    L33:
        throw th;
    L35:
        throw new IllegalStateException(getClass().getSimpleName().concat(" call counter would overflow"));
    L37:
        throw new IllegalStateException(getClass().getSimpleName().concat(" object has already been destroyed"));
    }

    public final TtCnpaResult e(String r110, String r111, String r112, String r113, boolean r114, boolean r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "inputPath");
        Intrinsics.checkNotNullParameter(r111, "outputPath");
        Intrinsics.checkNotNullParameter(r112, "label");
        Intrinsics.checkNotNullParameter(r113, "pId");
        FuncParamsX81df78889df4faba r100 = new FuncParamsX81df78889df4faba(r110, r111, r112, r113, Boolean.valueOf(r114), Boolean.valueOf(r115), Boolean.valueOf(r116));
        ByteBuffer r101 = ByteBuffer.allocateDirect(FuncParamsX81df78889df4faba.ADAPTER.encodedSize(r100));
        r100.encode(new ByteBufferOutputStream(r101));
    L3:
        long r102 = this.f271036c.get();
        if (r102 == 0) goto L37;
        if (r102 == Long.MAX_VALUE) goto L35;
        if (this.f271036c.compareAndSet(r102, 1 + r102) == false) goto L3;
        ArcHandle r103 = this.f271034a;     // Catch: Throwable -> L29
        if ((r103 instanceof ArcHandle.LongHandle) == false) goto L28;
        ByteBuffer r104 = MoltenFfiNativeWriteManifestX5170153001473729005(((ArcHandle.LongHandle) r103).f271030a, r101);     // Catch: Throwable -> L29
        if (this.f271036c.decrementAndGet() != 0) goto L16;
        a();
    L16:
        if (r104 != null) goto L18;
        InputStream r105 = new ByteArrayInputStream(new byte[0]);
    L39:
        tt_cnpa_sdk.proto.TtCnpaResult r106 = FuncReturnXb2c4f98239e616de.ADAPTER.decode(r105).ret;     // Catch: Exception -> L21
    L23:
        if (r104 == null) goto L26;
        MoltenFfiTtCnpaSdk.f271033a.getClass();
        MoltenFfiTtCnpaSdk.freeNativeMemory(r104);
    L26:
        return Tt_cnpa_sdkKt.b(r106);
    L21:
        e = move-exception;
        e.printStackTrace();
        r106 = FuncReturnXb2c4f98239e616de.ADAPTER.decode(new ByteArrayInputStream(new byte[0])).ret;
        goto L23
    L18:
        Intrinsics.checkNotNull(r104);
        r105 = new ByteBufferInputStream(r104);
        goto L39
    L28:
        throw new IllegalStateException(getClass().getSimpleName() + " pointer type mismatch(long expected)");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        if (this.f271036c.decrementAndGet() != 0) goto L33;
        a();
    L33:
        throw th;
    L35:
        throw new IllegalStateException(getClass().getSimpleName().concat(" call counter would overflow"));
    L37:
        throw new IllegalStateException(getClass().getSimpleName().concat(" object has already been destroyed"));
    }
}
