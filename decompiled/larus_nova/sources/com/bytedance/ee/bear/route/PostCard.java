package com.bytedance.ee.bear.route;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public interface PostCard {

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlagInt {
    }

    public static final enum Type extends Enum<Type> {
        public static final Type FORSETI = null;
        public static final Type NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f236635a = null;

        static {
            Type r100 = new Type(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            Type r101 = new Type("FORSETI", 1);
            FORSETI = r101;
            f236635a = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) f236635a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    PostCard a(ArrayList r100);

    PostCard b(CharSequence r100);

    PostCard c(String r100, Bundle r101);

    PostCard d(Context r100);

    void e();

    PostCard f(String r100, long r101);

    PostCard g(int r100, int r101);

    Type getType();

    PostCard h(Bundle r100);

    PostCard i(String r100, String r101);

    PostCard j(String r100, int r101);

    PostCard k(int r100);

    PostCard l(String r100, boolean r101);

    PostCard m(int r100);

    PostCard n(String r100, Serializable r101);

    PostCard o(String r100, Parcelable r101);
}
