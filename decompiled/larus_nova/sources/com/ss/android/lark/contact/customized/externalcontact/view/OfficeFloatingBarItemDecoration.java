package com.ss.android.lark.contact.customized.externalcontact.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class OfficeFloatingBarItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f419185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f419186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f419187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f419188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f419189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f419190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f419191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f419192h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<Integer, String> f419193i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f419194j;

    private OfficeFloatingBarItemDecoration() {
        this.f419185a = new Paint();
        this.f419186b = new Paint();
        this.f419187c = new Paint();
        this.f419193i = Collections.emptyMap();
        this.f419194j = Collections.emptyList();
    }

    public final String h(int r100) {
    L3:
        if (r100 < this.f419192h) goto L9;
        if (this.f419193i.containsKey(Integer.valueOf(r100)) == true) goto L7;
        r100 = r100 - 1;
        goto L3
    L7:
        return this.f419193i.get(Integer.valueOf(r100));
    L9:
        return null;
    }

    public static Map<Integer, String> i(Map<Integer, String> r100, int r101) {
        if (r100 == null) goto L4;
        if (r101 != 0) goto L7;
        return r100;
    L7:
        LinkedHashMap r102 = new LinkedHashMap(r100.size());
        Iterator r103 = ((LinkedHashMap) r100).entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        Map.Entry r104 = (Map.Entry) r103.next();
        Integer r105 = (Integer) r104.getKey();
        if (r105 == null) goto L9;
        r102.put(Integer.valueOf(r105.intValue() + r101), (String) r104.getValue());
        goto L9
    L14:
        return r102;
    L4:
        return Collections.emptyMap();
    }

    public OfficeFloatingBarItemDecoration(Context r100, Map r101, int r102) {
        Paint r103 = new Paint();
        this.f419185a = r103;
        Paint r104 = new Paint();
        this.f419186b = r104;
        Paint r105 = new Paint();
        this.f419187c = r105;
        this.f419193i = Collections.emptyMap();
        this.f419194j = Collections.emptyList();
        this.f419192h = Math.max(0, r102);
        this.f419188d = UIUtils.dp2px(r100, 32.0f);
        r103.setColor(ContextCompat.getColor(r100, R.color.bg_body));
        r105.setColor(ContextCompat.getColor(r100, R.color.bg_base));
        r104.setColor(ContextCompat.getColor(r100, R.color.text_caption));
        r104.setTextSize(UIUtils.dp2px(r100, 14.0f));
        r104.setAntiAlias(true);
        Paint.FontMetrics r106 = r104.getFontMetrics();
        float r107 = r106.bottom;
        this.f419189e = (int) (r107 - r106.top);
        this.f419190f = (int) r107;
        this.f419191g = UIUtils.dp2px(r100, 16.0f);
        if (r101 != null) goto L5;
        r101 = Collections.emptyMap();
    L5:
        this.f419194j = new LinkedList(new LinkedHashSet(r101.values()));
        this.f419193i = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r210, RecyclerView r211, RecyclerView.State r212) {
        super.onDraw(r210, r211, r212);
        int r100 = r211.getPaddingLeft();
        int r101 = r211.getWidth() - r211.getPaddingRight();
        int r102 = r211.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L20;
        View r104 = r211.getChildAt(r103);
        RecyclerView.LayoutParams r105 = (RecyclerView.LayoutParams) r104.getLayoutParams();
        int r106 = r211.getChildAdapterPosition(r104);
        if (r106 != (-1)) goto L8;
    L19:
        r103 = r103 + 1;
        goto L3
    L8:
        if (r106 < this.f419192h) goto L19;
        if (this.f419193i.containsKey(Integer.valueOf(r106)) == false) goto L14;
        String r110 = this.f419193i.get(Integer.valueOf(r106));
        int r111 = r104.getTop() - ((ViewGroup.MarginLayoutParams) r105).topMargin;
        r210.drawRect(r100, r111 - this.f419188d, r101, r111, this.f419185a);
        r210.drawText(r110, r104.getPaddingLeft() + this.f419191g, (r111 - ((this.f419188d - this.f419189e) / 2)) - this.f419190f, this.f419186b);
    L14:
        int r107 = r106 + 1;
        if (r107 < this.f419192h) goto L19;
        if (this.f419193i.containsKey(Integer.valueOf(r107)) == false) goto L19;
        int r108 = r104.getBottom() + ((ViewGroup.MarginLayoutParams) r105).bottomMargin;
        r210.drawRect(r100, r108, r101, 0 + r108, this.f419187c);
        goto L19
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        super.onDrawOver(r110, r111, r112);
        int r113 = ((LinearLayoutManager) r111.getLayoutManager()).findFirstVisibleItemPosition();
        if (r113 != (-1)) goto L6;
        return;
    L6:
        if (r113 >= this.f419192h) goto L8;
        return;
    L8:
        RecyclerView.ViewHolder r100 = r111.findViewHolderForAdapterPosition(r113);
        if (r100 != null) goto L11;
        return;
    L11:
        View r101 = r100.itemView;
        String r102 = h(r113);
        if (r102 != null) goto L14;
        return;
    L14:
        this.f419194j.indexOf(r102);
        boolean r103 = true;
        String r114 = h(r113 + 1);
        if (r114 != null) goto L17;
    L21:
        r103 = false;
    L22:
        r110.drawRect(r111.getPaddingLeft(), r111.getPaddingTop(), r111.getRight() - r111.getPaddingRight(), r111.getPaddingTop() + this.f419188d, this.f419185a);
        float r115 = r101.getPaddingLeft() + this.f419191g;
        int r116 = r111.getPaddingTop();
        int r104 = this.f419188d;
        r110.drawText(r102, r115, ((r116 + r104) - ((r104 - this.f419189e) / 2)) - this.f419190f, this.f419186b);
        if (r103 == false) goto L26;
        r110.restore();
        return;
    L26:
        return;
    L17:
        if (TextUtils.equals(r102, r114) == true) goto L21;
        if (((r101.getHeight() + r101.getTop()) + 0) >= this.f419188d) goto L21;
        r110.save();
        r110.translate(0.0f, ((r101.getHeight() + r101.getTop()) + 0) - this.f419188d);
        goto L22
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        if (r104 != (-1)) goto L7;
        r100.set(0, 0, 0, 0);
        return;
    L7:
        if (r104 >= this.f419192h) goto L11;
        r100.set(0, 0, 0, 0);
        return;
    L11:
        if (this.f419193i.containsKey(Integer.valueOf(r104)) == false) goto L13;
        int r105 = this.f419188d;
    L14:
        int r106 = r104 + 1;
        if (r106 < this.f419192h) goto L17;
        this.f419193i.containsKey(Integer.valueOf(r106));
    L17:
        r100.set(0, r105, 0, 0);
        return;
    L13:
        r105 = 0;
        goto L14
    }
}
