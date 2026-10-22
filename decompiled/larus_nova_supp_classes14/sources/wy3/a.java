package wy3;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.write.d;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a implements c {
    public final Context a;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b b;
    public d c;
    public final CommentColorMode d;
    public boolean e;
    public iy3.a<?> f;

    @Override // wy3.c
    public Context getContext() {
        return this.a;
    }

    public a(Context r2, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r3) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "pageOwner");
        this.a = r2;
        this.b = r3;
        this.d = CommentColorMode.MODE_LIGHT;
        new LinkedHashMap();
    }
}
