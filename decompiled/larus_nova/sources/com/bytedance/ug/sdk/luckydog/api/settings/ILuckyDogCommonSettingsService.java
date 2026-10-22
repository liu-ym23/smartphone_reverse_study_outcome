package com.bytedance.ug.sdk.luckydog.api.settings;

import com.ss.android.lark.banner.export.entity.BannerBizName;

/* JADX INFO: loaded from: classes3.dex */
public interface ILuckyDogCommonSettingsService {

    public static final enum Channel extends Enum<Channel> {
        public static final Channel DYNAMIC = null;
        public static final Channel POLL = null;
        public static final Channel STATIC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Channel[] f271593a = null;

        static {
            Channel r100 = new Channel("STATIC", 0);
            STATIC = r100;
            Channel r101 = new Channel(BannerBizName.DYNAMIC, 1);
            DYNAMIC = r101;
            Channel r102 = new Channel("POLL", 2);
            POLL = r102;
            f271593a = new Channel[]{r100, r101, r102};
        }

        public static Channel[] values() {
            return (Channel[]) f271593a.clone();
        }

        public static Channel valueOf(String r100) {
            return (Channel) r27.a.a(Channel.class, r100);
        }

        public Channel(String r100, int r101) {
            super(r100, r101);
        }
    }
}
