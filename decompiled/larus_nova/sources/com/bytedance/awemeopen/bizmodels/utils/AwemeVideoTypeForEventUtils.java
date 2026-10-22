package com.bytedance.awemeopen.bizmodels.utils;

import com.ss.android.ugc.aweme.discover.model.BackgroundConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
public final class AwemeVideoTypeForEventUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198234a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/utils/AwemeVideoTypeForEventUtils$AwemeType;", "", "LONG_VIDEO", "SHORT_VIDEO", BackgroundConfig.BackgroundType.TYPE_PICTURE, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
    public static final enum AwemeType extends Enum<AwemeType> {
        public static final AwemeType LONG_VIDEO = null;
        public static final AwemeType PICTURE = null;
        public static final AwemeType SHORT_VIDEO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AwemeType[] f198235a = null;

        public static AwemeType valueOf(String r100) {
            return (AwemeType) r27.a.a(AwemeType.class, r100);
        }

        public static AwemeType[] values() {
            return (AwemeType[]) f198235a.clone();
        }

        static {
            AwemeType r100 = new AwemeType("LONG_VIDEO", 0);
            LONG_VIDEO = r100;
            AwemeType r101 = new AwemeType("SHORT_VIDEO", 1);
            SHORT_VIDEO = r101;
            AwemeType r102 = new AwemeType(BackgroundConfig.BackgroundType.TYPE_PICTURE, 2);
            PICTURE = r102;
            f198235a = new AwemeType[]{r100, r101, r102};
        }

        public AwemeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }
}
