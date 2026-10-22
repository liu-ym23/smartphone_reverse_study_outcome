package com.bytedance.creativex.mediaimport.view.internal.validator;

import android.net.Uri;
import java.util.Arrays;
import java.util.Locale;
import ki4.e0;
import ki4.r;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public interface d<DATA> {

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final a f204098o1 = null;

    public static final class a implements d<r> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f204099a = null;

        static {
            f204099a = new a();
        }

        public a() {
        }

        public final String a(r r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r100, "<this>");
            int r101 = MathKt.roundToInt((r100.getDuration() * 1.0f) / 1000);
            int r102 = r101 % 60;
            int r103 = r101 / 60;
            int r104 = r103 / 60;
            int r105 = r103 % 60;
            if (r104 != 0) goto L5;
            StringCompanionObject r106 = StringCompanionObject.INSTANCE;
            return String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r105), Integer.valueOf(r102)}, 2));
        L5:
            StringCompanionObject r107 = StringCompanionObject.INSTANCE;
            return String.format(Locale.getDefault(), "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r104), Integer.valueOf(r105), Integer.valueOf(r102)}, 3));
        }
    }

    static {
        f204098o1 = a.f204099a;
    }

    String getFormattedDuration(DATA r100);

    int getHeight(DATA r100);

    String getPath(DATA r100);

    e0 getSourceType(DATA r100);

    Uri getUri(DATA r100);

    int getWidth(DATA r100);

    boolean isVideo(DATA r100);
}
