package qy3;

import android.content.Context;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vh.b;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a extends g<o14.a> implements b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f535185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final py3.a f535186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f535187g;

    /* JADX INFO: renamed from: qy3.a$a, reason: collision with other inner class name */
    public static final class C7405a {
    }

    static {
    }

    public a(View r100, py3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "params");
        super(r100);
        this.f535185e = r100;
        this.f535186f = r101;
        this.f535187g = r100.getContext();
    }
}
