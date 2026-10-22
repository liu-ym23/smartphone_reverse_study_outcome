package obb;

import android.graphics.Bitmap;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f522630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f522631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f522632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f522633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IconScene f522634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f522635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UserSession f522636g;

    /* JADX INFO: renamed from: obb.a$a, reason: collision with other inner class name */
    public static final class C7034a {
    }

    static {
    }

    public final Bitmap a() {
        Integer r100 = this.f522632c;
        if (r100 != null) goto L9;
        return null;
    L9:
        int r101 = rbb.a.f537002a;     // Catch: Exception -> L7
        return rbb.a.b(r100.intValue(), null);
    L7:
        Log.e("ContainerInfo", "");
        return null;
    }

    public a() {
        this.f522634e = IconScene.UNKNOW;
    }

    public a(IconScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        IconScene r101 = IconScene.UNKNOW;
        this.f522634e = r100;
    }

    public final void b(IconScene r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f522634e = r100;
    }

    public a(Boolean r100, Boolean r101, Integer r102) {
        this.f522634e = IconScene.UNKNOW;
        this.f522630a = r100;
        this.f522631b = r101;
        this.f522632c = r102;
    }
}
