package com.obric.miniapp.intent;

import com.obric.capabilitykit.entity.app.MusicEntity;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f397737a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f397738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MusicEntity[] f397739b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f397738a, r101.f397738a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f397739b, r101.f397739b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f397738a.hashCode() * 31) + Arrays.hashCode(this.f397739b);
        }

        public final String toString() {
            return "ReceivedMusicCard(cardId=" + this.f397738a + ", songs=" + Arrays.toString(this.f397739b) + ')';
        }

        public a(String r100, MusicEntity[] r101) {
            Intrinsics.checkNotNullParameter(r100, "cardId");
            Intrinsics.checkNotNullParameter(r101, "songs");
            this.f397738a = r100;
            this.f397739b = r101;
        }
    }

    static {
        f397737a = new u();
    }

    public u() {
    }

    public static JSONObject a(JSONObject r100) {
        Object r101 = r100.opt("widget_data");
        if ((r101 instanceof JSONObject) == true) goto L20;
        Object r102 = null;
        if ((r101 instanceof String) == false) goto L17;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        Object r104 = Result.m9449constructorimpl(new JSONObject((String) r101));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r104) == true) goto L21;
        r102 = r104;
    L21:
        return (JSONObject) r102;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L17:
        return null;
    L20:
        return (JSONObject) r101;
    }
}
