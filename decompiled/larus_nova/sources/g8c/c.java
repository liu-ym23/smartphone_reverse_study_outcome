package g8c;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.AttachmentViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<b> f480461a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, String> f480462b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, Uri> f480463c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, String> f480464d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, String> f480465e = null;

    public static final class a implements g8c.a {
        public a() {
        }

        @Override // g8c.a
        public final void onFailed(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Log.w(AttachmentViewModel.TAG, "upload:" + r100 + " onFailed:" + r101);
            c.a(r100);
        }

        @Override // g8c.a
        public final void a(String r100, int r101, long r102, long r110, String r111) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Log.d(AttachmentViewModel.TAG, "upload:" + r100 + " status:" + r101 + " progress:" + r102 + '/' + r110 + " fileToken:" + r111);
            if (r101 != 0) goto L5;
        L21:
            c.a(r100);
            return;
        L5:
            if (r101 == 2) goto L21;
            if (r101 == 3) goto L14;
            ArrayList<b> r103 = c.f480461a;
            Log.d(AttachmentViewModel.TAG, "triggerUploadProgressUpdate:" + r100);
            Iterator<b> r104 = c.f480461a.iterator();
        L10:
            if (r104.hasNext() == false) goto L34;
            b r105 = r104.next();
            String r106 = c.f480462b.get(r100);
            if (r106 == null) goto L10;
            r105.a(r106, r102, r110);
            goto L10
        L34:
            return;
        L14:
            if (r111 == null) goto L33;
            ArrayList<b> r107 = c.f480461a;
            Log.i(AttachmentViewModel.TAG, "triggerUploadSuccess:" + r100);
            Iterator<b> r108 = c.f480461a.iterator();
        L17:
            if (r108.hasNext() == false) goto L35;
            b r109 = r108.next();
            String r112 = c.f480462b.get(r100);
            if (r112 == null) goto L17;
            r109.c(r112, r111);
            goto L17
        L35:
            return;
        }
    }

    public c() {
    }

    static {
        f480461a = new ArrayList();
        f480462b = new HashMap();
        f480463c = new HashMap();
        f480464d = new HashMap();
        f480465e = new HashMap();
    }

    public static final void a(String r100) {
        Log.i(AttachmentViewModel.TAG, "triggerUploadFail:" + r100);
        Iterator<b> r101 = f480461a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        b r102 = r101.next();
        String r103 = f480462b.get(r100);
        if (r103 == null) goto L4;
        r102.b(r103);
        goto L4
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Log.i(AttachmentViewModel.TAG, "cancelUpload:".concat(r100));
        TodoDependencyHolder.a().ccmDependency().c(CollectionsKt.listOf(r100));
        HashMap<String, String> r101 = f480462b;
        String r102 = r101.get(r100);
        if (r102 == null) goto L6;
        r101.remove(r100);
        f480463c.remove(r102);
        f480464d.remove(r102);
        String r103 = f480465e.remove(r102);
        return;
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Log.i(AttachmentViewModel.TAG, "retryUpload:" + r100);
        String r101 = f480465e.get(r100);
        if (r101 == null) goto L11;
        Uri r102 = f480463c.get(r100);
        if (r102 == null) goto L7;
        e(r100, r102, r101);
    L7:
        String r103 = f480464d.get(r100);
        if (r103 == null) goto L12;
        f(r100, r103, r101);
        return;
    L12:
        return;
    }

    public static void c(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fileToken");
        Log.i(AttachmentViewModel.TAG, "preview:" + r101);
        TodoDependencyHolder.a().ccmDependency().d(r100, r101, r102);
    }

    public static String e(String r100, Uri r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        Log.i(AttachmentViewModel.TAG, "upload:" + r100);
        String r103 = TodoDependencyHolder.a().ccmDependency().b(r101, r102, new a());
        f480462b.put(r103, r100);
        f480463c.put(r100, r101);
        f480465e.put(r100, r102);
        return r103;
    }

    public static String f(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, "localPath");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        Log.i(AttachmentViewModel.TAG, "upload:" + r100);
        String r103 = TodoDependencyHolder.a().ccmDependency().e(r101, r102, new a());
        f480462b.put(r103, r100);
        f480464d.put(r100, r101);
        f480465e.put(r100, r102);
        return r103;
    }
}
