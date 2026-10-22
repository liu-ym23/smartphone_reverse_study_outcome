package com.bytedance.awemeopen.apps.framework.comment.emoji;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f194156a;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.comment.emoji.a$a, reason: collision with other inner class name */
    public static final class C2796a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f194157a = null;

        static {
            f194157a = new a();
        }
    }

    public a() {
        this.f194156a = y54.a.a().getSharedPreferences("aweme_emoji", 0);
    }
}
