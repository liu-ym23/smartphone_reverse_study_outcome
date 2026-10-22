package n85;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.drive.core.fragment.DriveMainFragment;
import com.bytedance.ee.bear.drive.core.fragment.DrivePreviewFragment;
import com.bytedance.ee.bear.drive.module.nativepreview.model.FileBlockResModel;
import com.bytedance.ee.bear.drive.view.preview.media.DriveMediaDurationVm;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import iu5.d;
import j85.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public final HashMap<String, FileBlockResModel> a;
    public final HashMap<String, Long> b;
    public String c;
    public String d;
    public final n85.a e;
    public DriveMediaDurationVm f;
    public final ArrayList<WeakReference<FragmentManager>> g;
    public int h;
    public WeakReference<f> i;
    public final Map<String, String> j;
    public final Map<String, CopyOnWriteArraySet<String>> k;

    public static class a {
        public static final b a = null;

        static {
            a = new b();
        }
    }

    public b() {
        this.a = new HashMap();
        this.b = new HashMap();
        this.d = null;
        this.g = new ArrayList();
        this.h = 0;
        this.j = new ConcurrentHashMap();
        this.k = new ConcurrentHashMap();
        this.e = new n85.a();
    }

    public static FragmentManager b(View r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Object r1 = r3.getTag(2131370303);
        if ((r1 instanceof FragmentManager) == false) goto L10;
        return (FragmentManager) r1;
    L10:
        if (r3.getParent() != null) goto L12;
    L15:
        return null;
    L12:
        if ((r3.getParent() instanceof View) == false) goto L15;
        return b((View) r3.getParent());
    }

    public static DrivePreviewFragment e(String r3) {
        FileBlockResModel r4 = a.a.a.get(r3);
        if (r4 != null) goto L6;
        tt5.a.h("FileBlockResPoll", "FileBlockResPoll found not!");
        return null;
    L6:
        FileBlockResModel.NativeViewHolder r5 = r4.getNativeViewHolder();
        if (r5 != null) goto L10;
        tt5.a.h("FileBlockResPoll", "nativeViewHolder found not!");
        return null;
    L10:
        Fragment r6 = r5.getFragment();
        if (r6 != null) goto L15;
        tt5.a.h("FileBlockResPoll", "fragment lifecycle error");
        return null;
    L15:
        if ((r6 instanceof DriveMainFragment) == true) goto L19;
        tt5.a.h("FileBlockResPoll", "fragment is not DriveMainFragment");
        return null;
    L19:
        return ((DriveMainFragment) r6).U90();
    }

    public final FragmentManager c(Fragment r5) {
        Iterator<WeakReference<FragmentManager>> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        FragmentManager r1 = r0.next().get();
        if (r1 == null) goto L4;
        List r2 = r1.getFragments();
        if (r2 == null) goto L4;
        if (r2.size() == 0) goto L4;
        Iterator r3 = r2.iterator();
    L15:
        if (r3.hasNext() == false) goto L4;
        if (((Fragment) r3.next()) != r5) goto L15;
        return r1;
    L19:
        return null;
    }

    public static FragmentManager a(FragmentManager r3, String r4) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.toString().equals(r4) == false) goto L8;
        return r3;
    L8:
        List r5 = r3.getFragments();
        if (r5 != null) goto L11;
    L25:
        return null;
    L11:
        if (r5.size() <= 0) goto L25;
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L25;
        Fragment r1 = (Fragment) r6.next();
        if (r1 == null) goto L14;
        if (r1.getHost() == null) goto L14;
        FragmentManager r2 = a(r1.getChildFragmentManager(), r4);
        if (r2 == null) goto L14;
        if (r2.toString().equals(r4) == false) goto L14;
        return r2;
    }

    public final void f(String r5, FileBlockResModel r6) {
        if (this.a.containsKey(r5) == false) goto L5;
    L16:
        r6.setUpdateTime(System.currentTimeMillis());
        tt5.a.b("FileBlockResPoll", "putResToPoll 11 size=" + this.a.size() + ", model=" + r6);
        this.a.put(r5, r6);
        return;
    L5:
        if (r6.isNeedShow() == true) goto L16;
        String r0 = this.e.a(this.a);
        tt5.a.b("FileBlockResPoll", "putResToPoll 22 size=" + this.a.size());
        if ("".equals(r0) == true) goto L14;
        FileBlockResModel.NativeViewHolder r1 = this.a.remove(r0).getNativeViewHolder();
        if (r1 == null) goto L14;
        if (r1.getFragment() == null) goto L14;
        r1.release();
    L14:
        r6.setUpdateTime(System.currentTimeMillis());
        this.a.put(r5, r6);
    }

    public final FragmentManager d(DriveMainFragment r3, FragmentActivity r4, View r5) {
        FragmentManager r6 = b(r5);
        tt5.a.h("FileBlockResPoll", "findViewFragmentManager() get viewFm=" + r6);
        if (r6 == null) goto L5;
        return r6;
    L5:
        d.a("drive_file_block_fm", new Exception("findViewFragmentManager is null"));
        if (this.g.size() > 0) goto L8;
        return null;
    L8:
        FragmentManager r7 = c(r3);
        if (r7 == null) goto L11;
        return r7;
    L11:
        if (r4 != null) goto L13;
        return null;
    L13:
        int r8 = this.g.size();
    L14:
        r8 = r8 - 1;
        if (r8 < 0) goto L22;
        FragmentManager r9 = (FragmentManager) ((WeakReference) ListProtector.get(this.g, r8)).get();
        if (r9 == null) goto L14;
        FragmentManager r10 = a(r4.getSupportFragmentManager(), r9.toString());
        if (r10 == null) goto L14;
        return r10;
    L22:
        return null;
    }
}
