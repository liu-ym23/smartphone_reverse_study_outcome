package hob;

import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f486339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f486340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f486341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f486342g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f486343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f486344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f486345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f486346d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f486347e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f486348f;

        public a() {
            this.f486343a = R.drawable.ud_icon_link_copy_filled;
            this.f486344b = "";
            this.f486348f = UIHelper.getColor(R.color.text_link_normal);
        }
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "href");
        super(r100);
        this.f486339d = true;
        this.f486340e = "";
        this.f486341f = new a();
    }
}
