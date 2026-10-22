package db5;

import android.text.TextUtils;
import com.bytedance.ee.bear.utils.LinkUtils;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;

/* JADX INFO: loaded from: classes16.dex */
public class j implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f467826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f467827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f467828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f467829d;

    public final j a() {
        return (j) super.clone();
    L4:
        e = move-exception;
        tt5.a.e(ComposerHelper.CONFIG_LINK, "clone Links failed", e, false);
        return null;
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public j(int r100, int r101, String r102) {
        this.f467826a = r100;
        this.f467827b = r101;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        this.f467828c = r102;
        this.f467829d = LinkUtils.a(r102);
    }

    public j(int r100, int r101, String r102, String r103) {
        this.f467826a = r100;
        this.f467827b = r101;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        this.f467828c = r102;
        if (TextUtils.isEmpty(r103) == false) goto L8;
        r103 = r102;
    L8:
        this.f467829d = LinkUtils.a(r103);
    }
}
