package com.ss.android.ugc.aweme.kiwi.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002J\u001d\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\nH\u0014J#\u0010\u0011\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\rH\u0016¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "mBagOfTags", "", "", "", "mCleared", "", "close", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "getTag", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Ljava/lang/String;)Ljava/lang/Object;", "onCleared", "setTagIfAbsent", "newValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "kiwi_release"}, k = 1, mv = {1, 1, 16})
public class QViewModel extends ViewModel {
    private final Map<String, Object> mBagOfTags;
    private volatile boolean mCleared;

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.mCleared = true;
        Map<String, Object> r100 = this.mBagOfTags;
        monitor-enter(r100);
        Iterator<Object> r101 = this.mBagOfTags.values().iterator();     // Catch: Throwable -> L11
    L6:
        if (r101.hasNext() == false) goto L8;
        close(r101.next());     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r100);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public QViewModel() {
        this.mBagOfTags = new HashMap();
    }

    private final void close(Object r100) {
        if ((r100 instanceof Closeable) == false) goto L11;
        ((Closeable) r100).close();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public <T> T getTag(String r100) {
        Map<String, Object> r101 = this.mBagOfTags;
        monitor-enter(r101);
        T r102 = (T) this.mBagOfTags.get(r100);
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public <T> T setTagIfAbsent(String r100, T r101) {
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        Map<String, Object> r103 = this.mBagOfTags;
        monitor-enter(r103);
        T r104 = (T) this.mBagOfTags.get(r100);
        r102.element = r104;     // Catch: Throwable -> L20
        if (r104 != null) goto L11;
        Map<String, Object> r105 = this.mBagOfTags;     // Catch: Throwable -> L20
        if (r101 == null) goto L10;
        r105.put(r100, r101);     // Catch: Throwable -> L20
        goto L11
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L20
    L11:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r103);
        T r107 = r102.element;
        if (r107 == null) goto L17;
        r101 = r107;
    L17:
        if (this.mCleared == false) goto L19;
        close(r101);
    L19:
        return r101;
    L20:
        th = move-exception;
        throw th;
    }
}
