package zj0;

import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f572378a;

    public static final class a extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f572379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f572380c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f572381d;

        public /* synthetic */ a() {
            throw null;
        }

        public final String toString() {
            return "FollowServer(scene=" + this.f572379b + ",uiLayout=" + this.f572380c + ",reqFrom=" + this.f572378a + ')';
        }

        public a(int r100, int r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r102, "reqFrom");
            super(r102);
            this.f572379b = r100;
            this.f572380c = r101;
            this.f572381d = r103;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f572382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f572383c;

        public final String toString() {
            return "Init(scene=" + this.f572382b + ",uiLayout=" + this.f572383c + ')';
        }

        public b(int r100, int r101) {
            super("Init");
            this.f572382b = r100;
            this.f572383c = r101;
        }
    }

    /* JADX INFO: renamed from: zj0.c$c, reason: collision with other inner class name */
    public static final class C8467c extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f572384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f572385c;

        public final String toString() {
            return "InitOnFastMode(scene=" + this.f572384b + ",uiLayout=" + this.f572385c + ')';
        }

        public C8467c(int r100, int r101) {
            super("Init");
            this.f572384b = r100;
            this.f572385c = r101;
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f572386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f572387c;

        public final String toString() {
            return "OrientationChange(scene=" + this.f572386b + ",uiLayout=" + this.f572387c + ')';
        }

        public d(int r100, int r101) {
            super(LinkConstant.SWITCH_LAYOUT_ORIENTATION_CHANGE);
            this.f572386b = r100;
            this.f572387c = r101;
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SeiAppData f572388b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f572389c;

        public final String toString() {
            return "SeiUpdate(ver=" + this.f572388b.getVersion() + ",style=" + this.f572388b.getStyle() + ",uiLayout=" + this.f572389c + ')';
        }

        public e(SeiAppData r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "sei");
            super(LinkConstant.SWITCH_LAYOUT_FROM_SEI_UPDATE);
            this.f572388b = r100;
            this.f572389c = r101;
        }
    }

    public static final class f extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f572390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f572391c;

        public final String toString() {
            return "VoiceChatSwitchLayoutFailed(scene=" + this.f572390b + ", uiLayout=" + this.f572391c + ", reqFrom=" + this.f572378a + ')';
        }

        public f(int r100) {
            super(LinkConstant.SWITCH_LAYOUT_FAILED);
            this.f572390b = 5;
            this.f572391c = r100;
        }
    }

    public c(String r100) {
        this.f572378a = r100;
    }
}
