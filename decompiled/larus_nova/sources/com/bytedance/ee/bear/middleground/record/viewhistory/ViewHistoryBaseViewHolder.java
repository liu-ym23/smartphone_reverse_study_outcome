package com.bytedance.ee.bear.middleground.record.viewhistory;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c7c.b;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.widgets.tagview.DisplayTagInfoV1;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import com.ss.android.lark.time.format.entity.LengthType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public class ViewHistoryBaseViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDAvatar f234352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpaceTagTitleView f234353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f234354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f234355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f234356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f234357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f234358g;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordListResult.a f234359a;

        public a(RecordListResult.a r100) {
            this.f234359a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f234359a.f234347k == false) goto L6;
            ((k) org.koin.java.a.a(k.class)).e(this.f234359a.f234337a, null);
            return;
        }
    }

    public final void U3(RecordListResult.a r100) {
        T3(r100, false, true);
        if (r100.f234346j == true) goto L7;
        this.f234354c.setVisibility(0);
        this.f234354c.setText(r100.f234343g);
        if (TextUtils.isEmpty(r100.f234343g) == false) goto L9;
        this.f234354c.setVisibility(8);
        return;
    L9:
        return;
    L7:
        this.f234354c.setVisibility(8);
    }

    public ViewHistoryBaseViewHolder(View r100, String r101) {
        super(r100);
        this.f234357f = r100.getContext();
        this.f234358g = r101;
        this.f234352a = (UDAvatar) r100.findViewById(R.id.read_record_item_avatar);
        this.f234353b = (SpaceTagTitleView) r100.findViewById(R.id.read_record_item_name_title);
        this.f234354c = (TextView) r100.findViewById(R.id.read_record_item_group);
        this.f234355d = (TextView) r100.findViewById(R.id.read_record_item_time);
        this.f234356e = r100.findViewById(R.id.divider);
    }

    public final void T3(RecordListResult.a r110, boolean r111, boolean r112) {
        this.f234352a.setAvatarSize(-2);
        Glide.with(this.f234352a.getContext()).load(r110.f234342f).placeholder(R.drawable.facade_common_avatar_place_holder).into(this.f234352a);
        this.f234353b.setTitle(ou5.a.a(this.f234358g, r110.f234340d, r110.f234338b, r110.f234339c));
        TextView r100 = this.f234355d;
        Context r101 = this.f234357f;
        long r102 = r110.f234344h * 1000;
        Map<String, SimpleDateFormat> r103 = zu5.a.f573665a;
        if (r101 == null) goto L5;
        boolean r104 = false;
    L6:
        String r105 = "";
        if (r104 == false) goto L10;
        String r106 = "";
    L19:
        r100.setText(r106);
        this.f234356e.setVisibility(0);
        this.f234352a.setOnClickListener(new a(r110));
        SpaceTagTitleView r107 = this.f234353b;
        SpaceTagType[] r108 = new SpaceTagType[2];
        DisplayTagInfoV1 r109 = r110.f234341e;
        if (r109 == null) goto L22;
        r105 = r109.tag_value;
    L22:
        if (r112 == true) goto L24;
    L26:
        boolean r113 = false;
    L27:
        int r114 = SpaceTagType.f240339e;
        r108[0] = SpaceTagType.Companion.f(r105, r113, true);
        r108[1] = SpaceTagType.a(r111);
        r107.setLabels(r108);
        return;
    L24:
        if (r110.f234346j == false) goto L26;
        r113 = true;
        goto L27
    L10:
        if (zu5.a.h(r101, r102) == false) goto L13;
        r106 = r101.getResources().getString(R.string.Doc_Util_Reminder_Format_Today);
        goto L19
    L13:
        if (zu5.a.i(r102) == false) goto L16;
        r106 = r101.getResources().getString(R.string.Doc_Util_Reminder_Format_Yesterday);
        goto L19
    L16:
        if (zu5.a.g(r101, r102) == false) goto L18;
        c7c.a r115 = new c7c.a();
        r115.c(LengthType.SHORT);
        r115.a(DatePreciseness.DAY);
        r106 = b.a(r101, new Date(r102), r115);
        goto L19
    L18:
        r106 = b.a(r101, new Date(r102), null);
        goto L19
    L5:
        r104 = true;
        goto L6
    }
}
