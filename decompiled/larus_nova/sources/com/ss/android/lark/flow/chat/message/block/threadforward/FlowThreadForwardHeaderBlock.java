package com.ss.android.lark.flow.chat.message.block.threadforward;

import android.view.View;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowThreadForwardHeaderBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<ThreadForwardContentVOV2>, Object> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f422493k = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f422494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IMMessageKeys$Slots f422495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f422496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f422497j;

    public static final class a {
    }

    public static final class b implements k<View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f422498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f422499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f422500c;

        @Override // com.ss.android.lark.blueprint.k
        public final View getView() {
            return this.f422498a;
        }

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f422498a = r100;
            this.f422499b = r100.findViewById(R.id.top_layout);
            TextView r101 = (TextView) r100.findViewById(R.id.post_thread_desc);
            this.f422500c = r101;
            zz7.a.c(r101, 14);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.blueprint.i
    public final j getKey() {
        return this.f422494g;
    }

    public FlowThreadForwardHeaderBlock(g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f422494g = IMMessageKeys$Blocks.FLOW_THREAD_FORWARD_HEADER;
        this.f422495h = IMMessageKeys$Slots.CONTENT;
        this.f422496i = LazyKt.lazy(new FlowThreadForwardHeaderBlock$replyInThreadCallback$2(this));
        this.f422497j = LazyKt.lazy(new FlowThreadForwardHeaderBlock$threadCallback$2(this));
    }

    public void update(m<y6b.a<ThreadForwardContentVOV2>> r100, q<y6b.a<ThreadForwardContentVOV2>> r101, y6b.a<ThreadForwardContentVOV2> r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        b r103 = (b) r101.c(this.f422494g, this.f422495h, FlowThreadForwardHeaderBlock$update$blockView$1.INSTANCE);
        ThreadForwardContentVOV2 r104 = r102.b();
        if (r104.f411941j.length() != 0) goto L5;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L9;
    L12:
        r103.f422500c.setText(ICUUtils.icuFormat(UIUtils.getString(getContext(), R.string.LarkIM_Thread_UsernameTopic_Title), "name", r104.f411940i.getName()));
    L13:
        String r106 = r102.getId();
        ThreadForwardContentVOV2 r107 = r102.b();
        Thread r108 = ((MergeForwardContent) r107.f553338a).getThread();
        if (r108 == null) goto L17;
        String r109 = r108.f253577id;
        if (r109 == null) goto L17;
    L18:
        r103.f422499b.setOnClickListener(new c(r107, this, r109, r106));
        r103.f422499b.setOnLongClickListener(new d(r100, this, r102));
        return;
    L17:
        r109 = "";
        goto L18
    L9:
        if (r104.f() == false) goto L12;
        String r110 = UIUtils.getString(getContext(), R.string.LarkIM_Group_TopicFromChat_Title);
        ICUUtils.FormatArgsBuilder r111 = new ICUUtils.FormatArgsBuilder();
        r111.b("name", r104.f411940i.getName());
        r111.b("source_chat_name", r104.f411941j);
        String r112 = ICUUtils.icuFormat(r110, r111.f285892a);
        r103.f422500c.setText(r112);
        goto L13
    L5:
        r105 = false;
        goto L7
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(m r100, q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
