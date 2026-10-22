package com.bytedance.bdp.serviceapi.defaults.ui.model;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpAnimationConfig {

    /* JADX INFO: renamed from: com.bytedance.bdp.serviceapi.defaults.ui.model.BdpAnimationConfig$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
    final class AnonymousClass1 extends Lambda implements Function1<Throwable, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable r100) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/bdp/serviceapi/defaults/ui/model/BdpAnimationConfig$ResMode;", "", "URL", "ASSET", "RAW_RES", "JSON_STREAM", "JSON_STRING", "ZIP_STREAM", "EMPTY", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
    public static final enum ResMode extends Enum<ResMode> {
        public static final ResMode ASSET = null;
        public static final ResMode EMPTY = null;
        public static final ResMode JSON_STREAM = null;
        public static final ResMode JSON_STRING = null;
        public static final ResMode RAW_RES = null;
        public static final ResMode URL = null;
        public static final ResMode ZIP_STREAM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResMode[] f201585a = null;

        static {
            ResMode r100 = new ResMode("URL", 0);
            URL = r100;
            ResMode r101 = new ResMode("ASSET", 1);
            ASSET = r101;
            ResMode r102 = new ResMode("RAW_RES", 2);
            RAW_RES = r102;
            ResMode r103 = new ResMode("JSON_STREAM", 3);
            JSON_STREAM = r103;
            ResMode r104 = new ResMode("JSON_STRING", 4);
            JSON_STRING = r104;
            ResMode r105 = new ResMode("ZIP_STREAM", 5);
            ZIP_STREAM = r105;
            ResMode r106 = new ResMode("EMPTY", 6);
            EMPTY = r106;
            f201585a = new ResMode[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static ResMode valueOf(String r100) {
            return (ResMode) r27.a.a(ResMode.class, r100);
        }

        public static ResMode[] values() {
            return (ResMode[]) f201585a.clone();
        }

        public ResMode(String r100, int r101) {
            super(r100, r101);
        }
    }
}
