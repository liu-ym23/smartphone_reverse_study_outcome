package com.ss.android.lark.thirdshare.panel;

import com.larus.nova.R;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import com.ss.android.lark.thirdshare.lark.export.bean.LarkChatShareActionType;

/* JADX INFO: loaded from: classes38.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShareActionType f441240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f441241b;

    public static final class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f441242c = 0;

        static {
            new a();
        }

        public a() {
            super(LarkChatShareActionType.a.f441234a.f441233a);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.thirdshare.panel.b$b, reason: collision with other inner class name */
    public static final class C5312b extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f441243c = 0;

        static {
            new C5312b().f441240a.getShareItemInfo().mNameResId = R.string.Lark_UD_SharePanelCopyLink;
        }

        public C5312b() {
            super(ShareActionType.COPY);
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f441244c = 0;

        static {
            new c();
        }

        public c() {
            super(ShareActionType.QQ);
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f441245c = 0;

        static {
            new d();
        }

        public d() {
            super(ShareActionType.SAVE);
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f441246c = 0;

        static {
            new e();
        }

        public e() {
            super(ShareActionType.SYS);
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f441247c = 0;

        static {
            new f();
        }

        public f() {
            super(ShareActionType.UNKNOWN);
        }
    }

    public static final class g extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f441248c = 0;

        static {
            new g();
        }

        public g() {
            super(ShareActionType.WB);
        }
    }

    public static final class h extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f441249c = 0;

        static {
            new h();
        }

        public h() {
            super(ShareActionType.WX);
        }
    }

    public static final class i extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f441250c = 0;

        static {
            new i();
        }

        public i() {
            super(ShareActionType.WX_TIMELINE);
        }
    }

    public final String getType() {
        return this.f441241b;
    }

    public b(ShareActionType r100) {
        String r101 = r100.name();
        this.f441240a = r100;
        this.f441241b = r101;
    }
}
