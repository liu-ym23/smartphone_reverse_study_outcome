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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, FileBlockResModel> f518319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Long> f518320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f518321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f518322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n85.a f518323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DriveMediaDurationVm f518324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<WeakReference<FragmentManager>> f518325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f518326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<f> f518327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f518328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, CopyOnWriteArraySet<String>> f518329k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f518330a = null;

        static {
            f518330a = new b();
        }
    }

    public b() {
        this.f518319a = new HashMap();
        this.f518320b = new HashMap();
        this.f518322d = null;
        this.f518325g = new ArrayList();
        this.f518326h = 0;
        this.f518328j = new ConcurrentHashMap();
        this.f518329k = new ConcurrentHashMap();
        this.f518323e = new n85.a();
    }

    public static FragmentManager b(View r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r101 = r100.getTag(R.id.drive_preview_block_fragment_manager);
        if ((r101 instanceof FragmentManager) == false) goto L10;
        return (FragmentManager) r101;
    L10:
        if (r100.getParent() != null) goto L12;
    L15:
        return null;
    L12:
        if ((r100.getParent() instanceof View) == false) goto L15;
        return b((View) r100.getParent());
    }

    public static DrivePreviewFragment e(String r100) {
        FileBlockResModel r101 = a.f518330a.f518319a.get(r100);
        if (r101 != null) goto L6;
        tt5.a.h("FileBlockResPoll", "FileBlockResPoll found not!");
        return null;
    L6:
        FileBlockResModel.NativeViewHolder r102 = r101.getNativeViewHolder();
        if (r102 != null) goto L10;
        tt5.a.h("FileBlockResPoll", "nativeViewHolder found not!");
        return null;
    L10:
        Fragment r103 = r102.getFragment();
        if (r103 != null) goto L15;
        tt5.a.h("FileBlockResPoll", "fragment lifecycle error");
        return null;
    L15:
        if ((r103 instanceof DriveMainFragment) == true) goto L19;
        tt5.a.h("FileBlockResPoll", "fragment is not DriveMainFragment");
        return null;
    L19:
        return ((DriveMainFragment) r103).U90();
    }

    public final FragmentManager c(Fragment r100) {
        Iterator<WeakReference<FragmentManager>> r101 = this.f518325g.iterator();
    L4:
        if (r101.hasNext() == false) goto L19;
        FragmentManager r102 = r101.next().get();
        if (r102 == null) goto L4;
        List<Fragment> r103 = r102.getFragments();
        if (r103 == null) goto L4;
        if (r103.size() == 0) goto L4;
        Iterator<Fragment> r104 = r103.iterator();
    L15:
        if (r104.hasNext() == false) goto L4;
        if (r104.next() != r100) goto L15;
        return r102;
    L19:
        return null;
    }

    public static FragmentManager a(FragmentManager r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.toString().equals(r101) == false) goto L8;
        return r100;
    L8:
        List<Fragment> r102 = r100.getFragments();
        if (r102 != null) goto L11;
    L25:
        return null;
    L11:
        if (r102.size() <= 0) goto L25;
        Iterator<Fragment> r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L25;
        Fragment r104 = r103.next();
        if (r104 == null) goto L14;
        if (r104.getHost() == null) goto L14;
        FragmentManager r105 = a(r104.getChildFragmentManager(), r101);
        if (r105 == null) goto L14;
        if (r105.toString().equals(r101) == false) goto L14;
        return r105;
    }

    public final void f(String r100, FileBlockResModel r101) {
        if (this.f518319a.containsKey(r100) == false) goto L5;
    L16:
        r101.setUpdateTime(System.currentTimeMillis());
        tt5.a.b("FileBlockResPoll", "putResToPoll 11 size=" + this.f518319a.size() + ", model=" + r101);
        this.f518319a.put(r100, r101);
        return;
    L5:
        if (r101.isNeedShow() == true) goto L16;
        String r102 = this.f518323e.a(this.f518319a);
        tt5.a.b("FileBlockResPoll", "putResToPoll 22 size=" + this.f518319a.size());
        if ("".equals(r102) == true) goto L14;
        FileBlockResModel.NativeViewHolder r103 = this.f518319a.remove(r102).getNativeViewHolder();
        if (r103 == null) goto L14;
        if (r103.getFragment() == null) goto L14;
        r103.release();
    L14:
        r101.setUpdateTime(System.currentTimeMillis());
        this.f518319a.put(r100, r101);
    }

    public final FragmentManager d(DriveMainFragment r100, FragmentActivity r101, View r102) {
        FragmentManager r103 = b(r102);
        tt5.a.h("FileBlockResPoll", "findViewFragmentManager() get viewFm=" + r103);
        if (r103 == null) goto L5;
        return r103;
    L5:
        d.a("drive_file_block_fm", new Exception("findViewFragmentManager is null"));
        if (this.f518325g.size() > 0) goto L8;
        return null;
    L8:
        FragmentManager r104 = c(r100);
        if (r104 == null) goto L11;
        return r104;
    L11:
        if (r101 != null) goto L13;
        return null;
    L13:
        int r105 = this.f518325g.size();
    L14:
        r105 = r105 - 1;
        if (r105 < 0) goto L22;
        FragmentManager r106 = (FragmentManager) ((WeakReference) ListProtector.get(this.f518325g, r105)).get();
        if (r106 == null) goto L14;
        FragmentManager r107 = a(r101.getSupportFragmentManager(), r106.toString());
        if (r107 == null) goto L14;
        return r107;
    L22:
        return null;
    }
}
