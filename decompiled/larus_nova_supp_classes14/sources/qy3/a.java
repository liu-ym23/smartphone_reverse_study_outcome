package qy3;

import android.content.Context;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a extends g<o14.a> implements b {
    public final View e;
    public final py3.a f;
    public final Context g;

    /* JADX INFO: renamed from: qy3.a$a, reason: collision with other inner class name */
    public static final class C0161a {
    }

    static {
    }

    public a(View r2, py3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "params");
        super(r2);
        this.e = r2;
        this.f = r3;
        this.g = r2.getContext();
    }
}
