package com.larus.bmhome.chat.list.cell.timestamp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.ChatListComponentViewModel;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.larus.utils.p0;
import com.ss.android.lark.utils.statistics.PerfLog;
import de8.c;
import ei9.f;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.i5;
import wc9.e;
import xc8.l;
import yg8.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002J(\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020!H\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0002J \u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001aH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/timestamp/TimestampCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/bmhome/chat/cell/TimestampCellState;", "<init>", "()V", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "topicText", "Landroid/widget/TextView;", "splitter", "Landroid/view/View;", "timeText", "sectionNameText", "onCreateBoxView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "", "boxType", "isSectionName", "", "editSectionName", "", "sectionName", "", "sectionID", "updateSectionName", "cvsID", "newSectionName", "getEditEventParams", "Lorg/json/JSONObject;", "botId", "cvsId", "bindData", "data", "Lcom/larus/im/bean/message/Message;", "onBindView", "view", "state", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimestampCell extends BaseMessageListCell<l> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f306540k = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f306541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f306542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f306543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f306544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f306545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f306546j;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
    }

    static {
    }

    public final y o() {
        return (y) this.f306542f.getValue();
    }

    public TimestampCell() {
        this.f306541e = LazyKt.lazy(new yg8.a(this));
        this.f306542f = LazyKt.lazy(new b(this));
    }

    public static JSONObject r(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("bot_id", r100);
        r102.put("conversation_id", r101);
        r102.put("click_from", "click_session_name");
        r102.put("current_page", "chat");
        return r102;
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final View m(Context r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r100 = null;
        View r113 = LayoutInflater.from(r110).inflate(R.layout.larus_item_timestamp, null, false);
        TextView r114 = (TextView) r113.findViewById(R.id.topic_text);
        r114.setVisibility(8);
        this.f306543g = r114;
        this.f306545i = (TextView) r113.findViewById(R.id.time_text);
        TextView r115 = (TextView) r113.findViewById(R.id.section_name_text);
        r115.setVisibility(8);
        this.f306546j = r115;
        c r116 = (c) this.f306541e.getValue();
        if (r116 == null) goto L5;
        r100 = r116.m();
    L5:
        if (r100 == null) goto L15;
        TextView r117 = this.f306543g;
        if (r117 == null) goto L9;
        r117.setTextColor(ContextCompat.getColor(r110, R.color.static_white_transparent_3));
    L9:
        TextView r118 = this.f306545i;
        if (r118 == null) goto L12;
        r118.setTextColor(ContextCompat.getColor(r110, R.color.static_white_transparent_3));
    L12:
        TextView r119 = this.f306546j;
        if (r119 == null) goto L24;
        r119.setTextColor(ContextCompat.getColor(r110, R.color.static_white_transparent_3));
    L24:
        this.f306544h = r113;
        return r113;
    L15:
        TextView r101 = this.f306543g;
        if (r101 == null) goto L18;
        we8.a.b(r101, i5.h(), false, Float.valueOf(i5.c()), null, 8);
    L18:
        TextView r102 = this.f306545i;
        if (r102 == null) goto L21;
        we8.a.b(r102, i5.h(), false, Float.valueOf(i5.c()), null, 8);
    L21:
        TextView r103 = this.f306546j;
        if (r103 == null) goto L24;
        we8.a.b(r103, i5.h(), false, Float.valueOf(i5.c()), null, 8);
        goto L24
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, f r101, int r102) {
        l r103 = (l) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        final Message r104 = r103.f563233a;
        TextView r105 = this.f306543g;
        if (r105 == null) goto L5;
        e1.o(r105);
    L5:
        long r106 = r104.getCreateTime();
        TextView r107 = this.f306545i;
        if (r107 == null) goto L8;
        r107.setText(oo8.b.a(r106 * ((long) 1000), false));
    L8:
        String r108 = r104.getMessageId();
        boolean r109 = true;
        if (r108 != null) goto L11;
    L13:
        boolean r110 = false;
    L14:
        if (r110 == false) goto L18;
        TextView r111 = this.f306545i;
        if (r111 == null) goto L18;
        e1.o(r111);
    L18:
        String r112 = r104.getContent();
        if (r112 == null) goto L27;
        TextView r113 = this.f306543g;
        if (r113 == null) goto L23;
        e1.x(r113);
    L23:
        TextView r114 = this.f306543g;
        if (r114 == null) goto L27;
        r114.setText(r112);
    L27:
        if (o0.d(r104.getSectionId()) == false) goto L82;
        y r115 = o();
        if (r115 == null) goto L43;
        e r116 = r115.h();
        if (r116 == null) goto L43;
        String r117 = r116.f559215r;
        if (r117 == null) goto L43;
        if (r117.length() > 0) goto L38;
        r109 = false;
    L38:
        if (r109 == true) goto L41;
        r117 = null;
    L41:
        if (r117 == null) goto L43;
        boolean r118 = Intrinsics.areEqual(p0.b(r117).optString("enable_section_rename", ""), "1");
    L44:
        if (r118 == false) goto L82;
        Map<String, String> r119 = r104.getExt();
        if (r119 == null) goto L48;
        String r120 = r119.get("visible_message_timestamp");
    L50:
        if (Intrinsics.areEqual(r120, "1") == true) goto L82;
        ChatListComponentViewModel.Companion.getClass();
        if (ChatListComponentViewModel.b.a(r104) == false) goto L59;
        TextView r121 = this.f306545i;
        if (r121 == null) goto L56;
        r121.setOnClickListener(null);
    L56:
        TextView r122 = this.f306546j;
        if (r122 == null) goto L66;
        r122.setOnClickListener(null);
    L66:
        if (o0.d(r104.getSectionName()) == false) goto L76;
        TextView r123 = this.f306546j;
        if (r123 == null) goto L70;
        r123.setText(r104.getSectionName());
    L70:
        TextView r124 = this.f306546j;
        if (r124 == null) goto L73;
        r124.setVisibility(0);
    L73:
        View r125 = this.f306544h;
        if (r125 == null) goto L95;
        r125.setPadding(i5.h(), 4, i5.h(), 4);
        return;
    L95:
        return;
    L76:
        TextView r126 = this.f306546j;
        if (r126 == null) goto L79;
        r126.setVisibility(8);
    L79:
        View r127 = this.f306544h;
        if (r127 == null) goto L97;
        r127.setPadding(i5.h(), 4, i5.h(), 4);
        return;
    L97:
        return;
    L59:
        View.OnClickListener r128 = new yg8.c(this, r104);
        TextView r129 = this.f306545i;
        if (r129 == null) goto L62;
        r129.setOnClickListener(r128);
    L62:
        TextView r130 = this.f306546j;
        if (r130 == null) goto L66;
        r130.setOnClickListener(r128);
        goto L66
    L48:
        r120 = null;
    L43:
        r118 = false;
    L82:
        TextView r131 = this.f306546j;
        if (r131 == null) goto L85;
        r131.setVisibility(8);
    L85:
        TextView r132 = this.f306545i;
        if (r132 == null) goto L88;
        r132.setOnClickListener(null);
    L88:
        TextView r133 = this.f306546j;
        if (r133 == null) goto L91;
        r133.setOnClickListener(null);
    L91:
        View r134 = this.f306544h;
        if (r134 == null) goto L99;
        r134.setPadding(i5.h(), 4, i5.h(), 4);
        return;
    L99:
        return;
    L11:
        if (StringsKt.contains$default(r108, ":fake_message:11", false, 2, null) != true) goto L13;
        r110 = true;
        goto L14
    }
}
