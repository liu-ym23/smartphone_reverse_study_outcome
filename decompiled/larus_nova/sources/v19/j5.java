package v19;

import android.content.Context;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j5 {
    public static final String b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "customString");
        return r100.getString(R.string.larus_dola_music_creator_global_global, new Object[]{r101, r100.getString(R.string.app_string_name)});
    }

    public static final String a(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getString(r102, new Object[]{r100.getString(r101)});
    }
}
