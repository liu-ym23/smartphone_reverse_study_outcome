package wy3;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.write.d;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f561863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b f561864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f561865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommentColorMode f561866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f561867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public iy3.a<?> f561868f;

    @Override // wy3.c
    public Context getContext() {
        return this.f561863a;
    }

    public a(Context r100, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "pageOwner");
        this.f561863a = r100;
        this.f561864b = r101;
        this.f561866d = CommentColorMode.MODE_LIGHT;
        new LinkedHashMap();
    }
}
