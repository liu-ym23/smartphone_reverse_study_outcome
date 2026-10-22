package com.ss.android.lark.filedetail.impl.folder.manage.drawable.property;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes35.dex */
public final class ExtraVideoProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f421672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f421673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f421674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f421675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f421676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f421677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f421678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f421679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Drawable f421680i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/drawable/property/ExtraVideoProperty$BGColorOrientation;", "", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface BGColorOrientation {
        public static final a Companion = null;
        public static final int HORIZONTAL = 0;
        public static final int VERTICAL = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f421681a = null;

            static {
                f421681a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f421681a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/drawable/property/ExtraVideoProperty$PlayPosition;", "", "Companion", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PlayPosition {
        public static final int BOTTOM_RIGHT = 1;
        public static final int CENTER = 0;
        public static final a Companion = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f421682a = null;

            static {
                f421682a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f421682a;
        }
    }

    public final Context getContext() {
        return this.f421672a;
    }

    public ExtraVideoProperty(Context r100, float r101, int r102, int r103, float r104, float r105, Drawable r106) {
        this.f421672a = r100;
        this.f421673b = r101;
        this.f421674c = 1;
        this.f421675d = r102;
        this.f421676e = r103;
        this.f421677f = 1;
        this.f421678g = r104;
        this.f421679h = r105;
        this.f421680i = r106;
    }
}
