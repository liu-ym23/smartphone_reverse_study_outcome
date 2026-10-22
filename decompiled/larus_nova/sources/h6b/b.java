package h6b;

import android.graphics.drawable.Drawable;
import com.larus.nova.R;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageSet f483932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f483933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f483934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f483935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f483936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ThemeColor f483937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f483938g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageSet f483939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f483940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Drawable f483941c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f483942d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f483943e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f483944f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ThemeColor f483945g;

        public a() {
            this.f483941c = UIHelper.getDrawable(R.drawable.ud_icon_link_copy_outlined);
            this.f483942d = UIHelper.getDrawable(R.drawable.ud_icon_image_fail_outlined);
            this.f483943e = 16;
            this.f483944f = 16;
        }
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f483932a = r100.f483939a;
        this.f483933b = r100.f483941c;
        this.f483934c = r100.f483942d;
        this.f483935d = r100.f483943e;
        this.f483936e = r100.f483944f;
        this.f483937f = r100.f483945g;
        this.f483938g = r100.f483940b;
    }
}
