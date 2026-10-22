package cw8;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.business.debug.base.DebugConstants$DebugTools$DebugToolsType;
import com.larus.business.debug.base.adapter.EntrancePageAdapter;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntrancePage;
import com.larus.business.debug.base.view.DebugEntranceRecyclerLinearLayoutManager;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import zv8.e;
import zv8.k;

/* JADX INFO: loaded from: classes26.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EntrancePage f465625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f465626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<EntranceGroup> f465627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f465628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f465629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EditText f465630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EntrancePageAdapter f465631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f465632h;

    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f465633a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public a(b r100) {
            this.f465633a = r100;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (r100 == null) goto L5;
            String r104 = r100.toString();
            if (r104 == null) goto L5;
        L6:
            EntrancePage r105 = this.f465633a.f465625a;
            k r106 = k.f573760a;
            Intrinsics.checkNotNullParameter(r104, "newText");
            Intrinsics.checkNotNullParameter(r105, "page");
            int r107 = k.a.f573770a[r105.ordinal()];
            boolean r108 = true;
            if (r107 != 1) goto L9;
            k.f573766g = r104;
            k r109 = k.f573760a;
            Map<EntranceGroup, LinkedList<e>> r110 = k.f573764e;
            r109.getClass();
            Map r111 = k.b(r104, r110);
            if (r111.size() == ((EnumMap) k.f573768i).size()) goto L21;
        L30:
            EnumMap r112 = (EnumMap) k.f573768i;
            r112.putAll(r111);
            if (r108 == false) goto L33;
            r112.clear();
            r112.putAll(r111);
        L33:
            boolean r113 = r108;
        L34:
            if (r113 == false) goto L36;
            this.f465633a.f465631g.y2();
        L36:
            int r114 = xv8.a.f565188a;
            xv8.a.a(DebugConstants$DebugTools$DebugToolsType.SEARCH, "search_input");
            return;
        L21:
            if (r111.isEmpty() == true) goto L30;
            Iterator r115 = ((LinkedHashMap) r111).keySet().iterator();
            boolean r116 = false;
        L25:
            if (r115.hasNext() == false) goto L29;
            EntranceGroup r117 = (EntranceGroup) r115.next();
            if (((EnumMap) k.f573768i).keySet().contains(r117) == true) goto L25;
            r116 = true;
            goto L25
        L29:
            r108 = r116;
            goto L30
        L9:
            if (r107 == 2) goto L14;
            k r118 = k.f573760a;
            List<Map<EntranceGroup, LinkedList<e>>> r119 = aw8.c.f16593a;
            List<Map<EntranceGroup, LinkedList<e>>> r120 = aw8.c.f16597e;
            r118.getClass();
            Pair r121 = k.a(r104, r119, r120);
            Intrinsics.checkNotNullParameter(r104, "searchText");
            Intrinsics.checkNotNullParameter(r121, "filterResult");
            aw8.c.f16596d = r104;
            if (((Boolean) r121.getSecond()).booleanValue() == false) goto L13;
            ArrayList r122 = (ArrayList) r120;
            r122.clear();
            r122.addAll((Collection) r121.getFirst());
        L13:
            r113 = ((Boolean) r121.getSecond()).booleanValue();
            goto L34
        L14:
            k.f573767h = r104;
            k r123 = k.f573760a;
            List<Map<EntranceGroup, LinkedList<e>>> r124 = k.f573765f;
            List<Map<EntranceGroup, LinkedList<e>>> r125 = k.f573769j;
            r123.getClass();
            Pair r126 = k.a(r104, r124, r125);
            boolean r127 = ((Boolean) r126.getSecond()).booleanValue();
            if (r127 == false) goto L17;
            ArrayList r128 = (ArrayList) r125;
            r128.clear();
            r128.addAll((Collection) r126.getFirst());
        L17:
            r113 = r127;
        L5:
            r104 = "";
            goto L6
        }
    }

    public void c() {
        this.f465629e.setAdapter(this.f465631g);
        RecyclerView.ItemAnimator r100 = this.f465629e.getItemAnimator();
        if (r100 == null) goto L5;
        r100.setChangeDuration(0);
    L5:
        RecyclerView.ItemAnimator r101 = this.f465629e.getItemAnimator();
        if ((r101 instanceof SimpleItemAnimator) == false) goto L8;
        SimpleItemAnimator r102 = (SimpleItemAnimator) r101;
    L9:
        if (r102 == null) goto L11;
        r102.setSupportsChangeAnimations(false);
    L11:
        this.f465631g.y2();
        this.f465629e.setLayoutManager(new DebugEntranceRecyclerLinearLayoutManager(this.f465626b.getContext()));
        EditText r103 = this.f465630f;
        if (r103 == null) goto L15;
        r103.addTextChangedListener(this.f465632h);
        return;
    L15:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public void d() {
        EditText r100 = this.f465630f;
        if (r100 == null) goto L6;
        r100.removeTextChangedListener(this.f465632h);
        return;
    }

    public b(EntrancePage r100, ViewGroup r101, List<EntranceGroup> r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "entranceGroupList");
        this.f465625a = r100;
        this.f465626b = r101;
        this.f465627c = r102;
        View r103 = LayoutInflater.from(r101.getContext()).inflate(R.layout.larus_debug_entrance_page, r101, false);
        this.f465628d = r103;
        this.f465629e = (RecyclerView) r103.findViewById(R.id.debug_entrance_page_recycler_view);
        this.f465630f = (EditText) r103.findViewById(R.id.debug_entrance_search_input);
        this.f465631g = new EntrancePageAdapter(r102, r100);
        this.f465632h = new a(this);
    }
}
