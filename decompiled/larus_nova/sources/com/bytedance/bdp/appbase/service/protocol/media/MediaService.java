package com.bytedance.bdp.appbase.service.protocol.media;

import com.bytedance.bdp.appbase.context.BdpAppContext;
import com.bytedance.bdp.appbase.context.service.ContextService;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
public abstract class MediaService extends ContextService<BdpAppContext> {

    public static final enum ScreenOrientation extends Enum<ScreenOrientation> {
        public static final ScreenOrientation LANDSCAPE = null;
        public static final ScreenOrientation PORTRAIT = null;
        public static final ScreenOrientation REVERSE_LANDSCAPE = null;
        public static final ScreenOrientation REVERSE_PORTRAIT = null;
        public static final ScreenOrientation SENSOR_LANDSCAPE = null;
        public static final ScreenOrientation SENSOR_PORTRAIT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScreenOrientation[] f200966a = null;

        static {
            ScreenOrientation r100 = new ScreenOrientation("LANDSCAPE", 0);
            LANDSCAPE = r100;
            ScreenOrientation r101 = new ScreenOrientation("REVERSE_LANDSCAPE", 1);
            REVERSE_LANDSCAPE = r101;
            ScreenOrientation r102 = new ScreenOrientation("PORTRAIT", 2);
            PORTRAIT = r102;
            ScreenOrientation r103 = new ScreenOrientation("REVERSE_PORTRAIT", 3);
            REVERSE_PORTRAIT = r103;
            ScreenOrientation r104 = new ScreenOrientation("SENSOR_LANDSCAPE", 4);
            SENSOR_LANDSCAPE = r104;
            ScreenOrientation r105 = new ScreenOrientation("SENSOR_PORTRAIT", 5);
            SENSOR_PORTRAIT = r105;
            f200966a = new ScreenOrientation[]{r100, r101, r102, r103, r104, r105};
        }

        public static ScreenOrientation[] values() {
            return (ScreenOrientation[]) f200966a.clone();
        }

        public static ScreenOrientation valueOf(String r100) {
            return (ScreenOrientation) a.a(ScreenOrientation.class, r100);
        }

        public ScreenOrientation(String r100, int r101) {
            super(r100, r101);
        }
    }
}
