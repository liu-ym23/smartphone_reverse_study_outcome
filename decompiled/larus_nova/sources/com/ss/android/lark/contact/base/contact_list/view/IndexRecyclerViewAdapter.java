package com.ss.android.lark.contact.base.contact_list.view;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u00020\u0005:\u0002 !B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\nH\u0016J\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH&J\u0016\u0010\u001e\u001a\u00120\u001fR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/ss/android/lark/contact/base/contact_list/view/IndexRecyclerViewAdapter;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "DATA", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/ss/android/lark/contact/base/contact_list/view/IndexDataOwner;", "<init>", "()V", "indexDataObservers", "", "Lcom/ss/android/lark/contact/base/contact_list/view/IndexDataOwner$IndexDataObserver;", "indices", "", "", "", "notifyIndexDataChanged", "", "isIndexEnable", "", "()Z", "setIndexEnable", "(Z)V", "getIndices", "", "registerDataObserver", "observer", "unregisterDataObserver", "genIndexData", "items", "", "getIndexFinder", "Lcom/ss/android/lark/contact/base/contact_list/view/IndexRecyclerViewAdapter$IndexFinder;", "IndexFinder", "IndexSection", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class IndexRecyclerViewAdapter<VH extends RecyclerView.ViewHolder, DATA> extends LarkRecyclerViewBaseAdapter<VH, DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f418626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, String> f418627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f418628c;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IndexRecyclerViewAdapter<VH, DATA> f418629a;

        public a(IndexRecyclerViewAdapter r100) {
            this.f418629a = r100;
        }

        public final b a(int r110) {
            ArrayList r100 = new ArrayList(((LinkedHashMap) this.f418629a.f418627b).keySet());
            int r101 = r100.size();
            int r102 = r101 - 1;
            int r103 = 0;
        L4:
            if (r103 >= r102) goto L15;
            if (((Number) ListProtector.get(r100, r103)).intValue() > r110) goto L14;
            int r104 = r103 + 1;
            if (r110 >= ((Number) ListProtector.get(r100, r104)).intValue()) goto L14;
            Integer r111 = (Integer) ListProtector.get(r100, r103);
            String r105 = (String) ((LinkedHashMap) this.f418629a.f418627b).get(r111);
            if (r105 != null) goto L12;
            return null;
        L12:
            Intrinsics.checkNotNull(r111);
            return new b(r103, r105, r111.intValue(), ((Number) ListProtector.get(r100, r104)).intValue(), r101);
        L14:
            r103 = r103 + 1;
            goto L4
        L15:
            if (r101 > 0) goto L17;
        L23:
            return null;
        L17:
            if (r110 < ((Number) ListProtector.get(r100, r102)).intValue()) goto L23;
            String r106 = (String) ((LinkedHashMap) this.f418629a.f418627b).get((Integer) ListProtector.get(r100, r102));
            if (r106 != null) goto L22;
            return null;
        L22:
            return new b(r102, r106, ((Number) ListProtector.get(r100, r102)).intValue(), Integer.MAX_VALUE, r101);
        }

        public final b b(String r110) {
            Intrinsics.checkNotNullParameter(r110, "indexName");
            ArrayList r100 = new ArrayList(((LinkedHashMap) this.f418629a.f418627b).keySet());
            int r101 = r100.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L13;
            Integer r103 = (Integer) ListProtector.get(r100, r102);
            if (TextUtils.equals(r110, (CharSequence) ((LinkedHashMap) this.f418629a.f418627b).get(r103)) == true) goto L7;
            r102 = r102 + 1;
            goto L3
        L7:
            if (r102 != (r100.size() - 1)) goto L9;
            Integer r104 = Integer.MAX_VALUE;
        L10:
            Intrinsics.checkNotNull(r103);
            int r105 = r103.intValue();
            Intrinsics.checkNotNull(r104);
            return new b(r102, r110, r105, r104.intValue(), r101);
        L9:
            r104 = (Integer) ListProtector.get(r100, r102 + 1);
            goto L10
        L13:
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f418630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f418631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f418632c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f418633d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f418634e;

        public b(int r100, String r101, int r102, int r103, int r104) {
            Intrinsics.checkNotNullParameter(r101, "indexName");
            this.f418630a = r100;
            this.f418631b = r101;
            this.f418632c = r102;
            this.f418633d = r103;
            this.f418634e = r104;
        }
    }

    public abstract Map<Integer, String> z2(List<? extends DATA> r100);

    public IndexRecyclerViewAdapter() {
        this.items = new AnonymousClass1(this);
        this.f418626a = new CopyOnWriteArrayList();
        this.f418627b = new LinkedHashMap();
        this.f418628c = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void y2(IndexRecyclerViewAdapter r100) {
        if (r100.f418628c == false) goto L9;
        Map<Integer, String> r101 = r100.z2(r100.items);
        ((LinkedHashMap) r100.f418627b).clear();
        r100.f418627b.putAll(r101);
        Iterator r102 = ((CopyOnWriteArrayList) r100.f418626a).iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        ((d) r102.next()).b();
        goto L7
    L11:
        return;
    }

    public final void A2(d r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (((CopyOnWriteArrayList) this.f418626a).contains(r100) == true) goto L6;
        ((CopyOnWriteArrayList) this.f418626a).add(r100);
        return;
    }
}
