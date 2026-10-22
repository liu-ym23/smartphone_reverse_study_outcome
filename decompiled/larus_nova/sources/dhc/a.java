package dhc;

import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import androidx.collection.SparseArrayCompat;
import java.util.Queue;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArrayCompat<Integer> f468668a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArrayCompat<Queue<View>> f468669b = null;

    static {
        new Handler(Looper.getMainLooper());
        new SparseArray();
        new Canvas();
        f468668a = new SparseArrayCompat();
        f468669b = new SparseArrayCompat();
        new SparseArrayCompat();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        if (r100.what != 1001) goto L10;
        Object r101 = r100.obj;
        if (r101 == null) goto L9;
        ((ehc.a) r101).a();
        return true;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.ss.android.ugc.live.async_pre_layout_view.provider.AbsLayoutProvider<*>");
    L10:
        return false;
    }
}
