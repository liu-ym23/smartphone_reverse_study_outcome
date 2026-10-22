package com.larus.bmhome.chat.list.cell.video;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.holder.helper.b1;
import com.larus.bmhome.chat.layout.item.s3;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0015H\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/video/VideoUnavailableCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/bmhome/chat/list/cell/video/VideoCellState;", "<init>", "()V", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "Lkotlin/Lazy;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "onCreateBoxView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "", "boxType", "onBindView", "", "view", "state", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoUnavailableCell extends BaseMessageListCell<u> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f306561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f306562f;

    public VideoUnavailableCell() {
        this.f306561e = LazyKt.lazy(new w(this));
        this.f306562f = LazyKt.lazy(new x(this));
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final View m(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        s3 r103 = new s3(r100);
        de8.c r104 = (de8.c) this.f306562f.getValue();
        if (r104 == null) goto L5;
        Integer r105 = r104.m();
    L6:
        r103.setImmerseBgColor(r105);
        ChatParam r106 = (ChatParam) this.f306561e.getValue();
        if (r106 == null) goto L11;
        boolean r107 = true;
        if (r106.f296894f != true) goto L11;
    L12:
        r103.setUseSubscribedColor(r107);
        r103.setBoxType(r102);
        return r103;
    L11:
        r107 = false;
        goto L12
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final void onBindView(View r110, ei9.f r111, int r112) {
        u r113 = (u) r111;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r113, "state");
        Message r100 = r113.f563233a;
        if (r100 == null) goto L30;
        q0.a r114 = null;
        if ((r110 instanceof s3) == false) goto L8;
        s3 r115 = (s3) r110;
    L9:
        if (r115 == null) goto L29;
        AppCompatTextView r101 = r115.getTextView();
        if (r101 != null) goto L14;
        return;
    L14:
        if (r100.getMessageStatusLocal() != 22) goto L16;
        r101.setText("...");
    L17:
        float r102 = i5.t();
        de8.c r116 = (de8.c) this.f306562f.getValue();
        if (r116 == null) goto L20;
        Integer r117 = r116.m();
    L21:
        if (r117 == null) goto L23;
        boolean r103 = true;
    L24:
        we8.a.b(r101, r102, r103, null, null, 12);
        q0 r104 = lf8.a.b(this);
        q0 r105 = lf8.a.b(this);
        if (r105 == null) goto L27;
        r114 = r105.getProvider();
    L27:
        b1.a(new com.larus.bmhome.chat.layout.holder.helper.o(r100, r104, r114, null, null, null, null, 120), r110);
        return;
    L23:
        r103 = false;
        goto L24
    L20:
        r117 = null;
        goto L21
    L16:
        r101.setText(R.string.larus_chat_unsupported_message_type);
        goto L17
    L29:
        return;
    L8:
        r115 = null;
        goto L9
    }
}
