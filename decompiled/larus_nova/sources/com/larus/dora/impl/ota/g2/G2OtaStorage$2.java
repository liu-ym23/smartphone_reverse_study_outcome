package com.larus.dora.impl.ota.g2;

import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class G2OtaStorage$2 extends FunctionReferenceImpl implements Function1<String, Long> {
    public static final G2OtaStorage$2 INSTANCE = null;

    static {
        INSTANCE = new G2OtaStorage$2();
    }

    public G2OtaStorage$2() {
        super(1, DownloadUtils.class, "getAvailableSpaceBytes", "getAvailableSpaceBytes(Ljava/lang/String;)J", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Long invoke2(String r100) {
        return Long.valueOf(DownloadUtils.getAvailableSpaceBytes(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(String r100) {
        return invoke2(r100);
    }
}
