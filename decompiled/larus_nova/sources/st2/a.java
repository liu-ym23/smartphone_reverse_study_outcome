package st2;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.f2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SdkResponse f543546a;

    public a(SdkResponse r100) {
        this.f543546a = r100;
    }

    public final void a() {
        StringBuilder r100 = new StringBuilder("Host WS Message: ");
        List<SdkMessage> r101 = this.f543546a.messages;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((SdkMessage) r103.next()).method);
        goto L4
    L6:
        r100.append(TextUtils.join(",", r102));
        f2.c(r100.toString(), 0);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
