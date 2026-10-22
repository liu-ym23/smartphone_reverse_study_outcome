package com.larus.bmhome.chat.layout.holder.progressloading;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public interface ISketchLoadingController {

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/progressloading/ISketchLoadingController$LoadingAssetType;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LoadingAssetType {
        public static final a Companion = null;
        public static final int IMAGE = 1;
        public static final int VIDEO = 2;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f304018a = null;

            static {
                f304018a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f304018a;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(ISketchLoadingController r100, String r101, int r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r102 = i5.h();
        L6:
            if ((r103 & 4) == 0) goto L8;
            int r104 = i5.Y();
        L9:
            r100.a(r101, r102, r104);
            return;
        L8:
            r104 = 0;
            goto L9
        }

        public static /* synthetic */ void b(ISketchLoadingController r100, boolean r101, ImageLoadingDrawPartType r102, int r103, int r104) {
            if ((r104 & 1) == 0) goto L6;
            r101 = false;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = null;
        L9:
            if ((r104 & 4) == 0) goto L11;
            r103 = 1;
        L11:
            r100.b(r101, r102, r103);
        }
    }

    void a(String r100, int r101, int r102);

    void b(boolean r100, ImageLoadingDrawPartType r101, int r102);

    void c(String r100);

    void hide();

    Boolean isVisible();

    void setProgress(int r100);
}
