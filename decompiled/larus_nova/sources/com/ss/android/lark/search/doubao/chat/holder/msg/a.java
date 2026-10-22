package com.ss.android.lark.search.doubao.chat.holder.msg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larus.nova.R;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchMessageInfo;
import com.ss.android.lark.search.ui.result.BinderConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import f4c.e;
import f4c.g;
import java.text.SimpleDateFormat;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w3c.f;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements com.ss.android.lark.search.ui.result.adapter.b<SearchMessageInfo, MessageViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BinderConfig f440080a;

    /* JADX INFO: renamed from: com.ss.android.lark.search.doubao.chat.holder.msg.a$a, reason: collision with other inner class name */
    public static final class C5284a {
    }

    static {
    }

    public a(BinderConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f440080a = r100;
    }

    @Override // com.ss.android.lark.search.ui.result.adapter.b
    public final void b(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter((MessageViewHolder) r100, "holder");
    }

    @Override // com.ss.android.lark.search.ui.result.adapter.b
    public final void c(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter((MessageViewHolder) r100, "holder");
    }

    @Override // com.ss.android.lark.search.ui.result.adapter.b
    public final void e(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter((MessageViewHolder) r100, "holder");
    }

    @Override // com.ss.android.lark.search.ui.result.adapter.b
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter((MessageViewHolder) r100, "holder");
    }

    @Override // com.ss.android.lark.search.ui.result.adapter.b
    public final RecyclerView.ViewHolder d(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = LayoutInflater.from(r100).inflate(R.layout.doubao_chat_search_message_layout, r101, false);
        Intrinsics.checkNotNull(r102);
        return new MessageViewHolder(r102);
    }

    public final void f(RecyclerView.ViewHolder r100, SearchBaseInfo r101, int r110) {
        MessageViewHolder r102 = (MessageViewHolder) r100;
        SearchMessageInfo r103 = (SearchMessageInfo) r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        LarkAvatarView r104 = r102.f440076a;
        uz7.a.C7948a r105 = new uz7.a.C7948a();
        r105.b(r103.getAvatarKey());
        r105.f(r103.getId());
        r104.j(new uz7.a(r105));
        g r106 = g.f475603a;
        TextView r107 = r102.f440077b;
        w3c.g r108 = new w3c.g(r103.getTitle(), false, 14);
        r108.f558239e = r103.getTitleTagList();
        Unit r109 = Unit.INSTANCE;
        g.a(r107, r108);
        e r111 = e.f475601a;
        TextView r112 = r102.f440078c;
        f r113 = new f(r103.getSubTitle());
        r113.f558230c = r103.getSubTitleTagList();
        r111.a(r112, r113);
        TextView r114 = r102.f440079d;
        if (r103.getUpdateTime() == 0) goto L5;
        StringBuilder r115 = new StringBuilder(" · ");
        SimpleDateFormat r116 = c.f440084a;
        r115.append(c.a(r103.getUpdateTime()));
        String r117 = r115.toString();
    L6:
        r114.setText(r117);
        r102.itemView.setOnClickListener(new b(this, r103, r110));
        return;
    L5:
        StringBuilder r118 = new StringBuilder(" · ");
        SimpleDateFormat r119 = c.f440084a;
        r118.append(c.a(r103.getCreateTime()));
        r117 = r118.toString();
        goto L6
    }

    @Override // com.ss.android.lark.search.ui.result.adapter.b
    public final void a(RecyclerView.ViewHolder r100, SearchBaseInfo r101, int r102, List r103) {
        MessageViewHolder r104 = (MessageViewHolder) r100;
        Intrinsics.checkNotNullParameter(r104, "holder");
        Intrinsics.checkNotNullParameter(r103, "payloads");
        f(r104, (SearchMessageInfo) r101, r102);
    }
}
