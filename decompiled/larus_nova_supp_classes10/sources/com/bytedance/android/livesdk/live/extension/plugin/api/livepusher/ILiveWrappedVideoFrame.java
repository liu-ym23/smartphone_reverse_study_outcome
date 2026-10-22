package com.bytedance.android.livesdk.live.extension.plugin.api.livepusher;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface ILiveWrappedVideoFrame {

    public interface ILiveWrappedTextureBuffer extends a {

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/livepusher/ILiveWrappedVideoFrame$ILiveWrappedTextureBuffer$ILiveWrappedType;", "", "", "glTarget", "I", "getGlTarget", "()I", "OES", "RGB", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum ILiveWrappedType extends Enum<ILiveWrappedType> {
            public static final ILiveWrappedType OES = null;
            public static final ILiveWrappedType RGB = null;
            public static final /* synthetic */ ILiveWrappedType[] a = null;
            private final int glTarget;

            static {
                ILiveWrappedType r1 = new ILiveWrappedType("OES", 0, 36197);
                OES = r1;
                ILiveWrappedType r2 = new ILiveWrappedType("RGB", 1, 3553);
                RGB = r2;
                a = new ILiveWrappedType[]{r1, r2};
            }

            public static ILiveWrappedType valueOf(String r1) {
                return (ILiveWrappedType) r27.a.a(ILiveWrappedType.class, r1);
            }

            public static ILiveWrappedType[] values() {
                return (ILiveWrappedType[]) a.clone();
            }

            public final int getGlTarget() {
                return this.glTarget;
            }

            public ILiveWrappedType(String r1, int r2, int r3) {
                super(r1, r2);
                this.glTarget = r3;
            }
        }

        ILiveWrappedType getType();
    }

    public interface a {
    }
}
