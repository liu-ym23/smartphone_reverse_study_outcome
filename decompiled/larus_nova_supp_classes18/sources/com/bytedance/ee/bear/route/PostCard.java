package com.bytedance.ee.bear.route;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface PostCard {

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlagInt {
    }

    public static final enum Type extends Enum<Type> {
        public static final Type FORSETI = null;
        public static final Type NORMAL = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r0 = new Type("NORMAL", 0);
            NORMAL = r0;
            Type r1 = new Type("FORSETI", 1);
            FORSETI = r1;
            a = new Type[]{r0, r1};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    PostCard a(ArrayList r1);

    PostCard b(CharSequence r1);

    PostCard c(String r1, Bundle r2);

    PostCard d(Context r1);

    void e();

    PostCard f(String r1, long r2);

    PostCard g(int r1, int r2);

    Type getType();

    PostCard h(Bundle r1);

    PostCard i(String r1, String r2);

    PostCard j(String r1, int r2);

    PostCard k(int r1);

    PostCard l(String r1, boolean r2);

    PostCard m(int r1);

    PostCard n(String r1, Serializable r2);

    PostCard o(String r1, Parcelable r2);
}
