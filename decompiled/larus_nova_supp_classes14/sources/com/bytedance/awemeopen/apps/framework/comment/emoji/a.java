package com.bytedance.awemeopen.apps.framework.comment.emoji;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final SharedPreferences a;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.comment.emoji.a$a, reason: collision with other inner class name */
    public static final class C0069a {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.a = y54.a.a().getSharedPreferences("aweme_emoji", 0);
    }
}
