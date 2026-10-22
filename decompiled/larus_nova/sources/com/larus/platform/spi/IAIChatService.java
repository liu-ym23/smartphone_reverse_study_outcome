package com.larus.platform.spi;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.bot.utils.c;
import com.larus.bmhome.chat.adapter.j;
import com.larus.bmhome.chat.api.b0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.immerse.j0;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.chat.layout.holder.progressloading.LoadingType;
import com.larus.bmhome.chat.markdown.code.f;
import com.larus.bmhome.chat.markdown.code.g;
import com.larus.bmhome.chat.markdown.code.h;
import com.larus.bmhome.chat.markdown.code.i;
import com.larus.bmhome.tipoff.BaseTipOffDialog;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotSourceType;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.conversation.BotConversationType;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.model.EditPos;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.xbridge.custom.v;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hw8.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lw8.l;
import sr9.d;
import sr9.e0;
import wc9.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ü\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u0092\u00022\u00020\u0001:\u0002\u0092\u0002J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&JD\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u000eH&J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H&J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0007H&J \u0010\u001c\u001a\u00020\u00072\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH&J\b\u0010\u001f\u001a\u00020\u000eH&J4\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0003H&Js\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00032\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030,23\u0010-\u001a/\u0012%\u0012#\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030/0,¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00070.H&J:\u00103\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u00032\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u000109H&J\b\u0010:\u001a\u00020\u000eH&J\b\u0010;\u001a\u00020\u000eH&J\b\u0010<\u001a\u00020\u0014H&J&\u0010=\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010\u0003H&J&\u0010C\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010\u0003H&J\\\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010>\u001a\u00020?2\u0006\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u000e2\b\b\u0002\u0010H\u001a\u00020\u000e2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001092\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u000109H&J\"\u0010L\u001a\u00020\u00142\b\b\u0001\u0010M\u001a\u00020\u00142\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020OH'J\b\u0010Q\u001a\u00020RH&J\b\u0010S\u001a\u00020TH&J\b\u0010U\u001a\u00020VH&J\b\u0010W\u001a\u00020XH&J\b\u0010Y\u001a\u00020ZH&J\b\u0010[\u001a\u00020\\H&J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H&J8\u0010a\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010b\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010f\u001a\u00020\u000e2\b\b\u0002\u0010g\u001a\u00020\u000eH&JB\u0010h\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010b\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010f\u001a\u00020\u000e2\b\u0010i\u001a\u0004\u0018\u00010j2\b\b\u0002\u0010g\u001a\u00020\u000eH&J\u0014\u0010k\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J \u0010l\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010,2\b\u0010m\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010nJ\u0010\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u0003H&J\b\u0010q\u001a\u00020\u0007H&J\b\u0010r\u001a\u00020\u0007H&J\u0013\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00030tH&¢\u0006\u0002\u0010uJ\u000e\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00030,H&J\u0010\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u00020\u0003H&J\u0019\u0010y\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0002\u0010zJ\u0014\u0010{\u001a\u0004\u0018\u00010|2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J/\u0010}\u001a\u00020\u00032\n\b\u0001\u0010~\u001a\u0004\u0018\u00010\u00142\n\b\u0001\u0010\u007f\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u0080\u0001\u001a\u00020\u000eH&¢\u0006\u0003\u0010\u0081\u0001JS\u0010\u0082\u0001\u001a\u00020\u000e2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010,H&J\f\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001H&J\f\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001H&J\f\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H&J\u001d\u0010\u0095\u0001\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H&J\u0013\u0010\u0096\u0001\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0003H&J\u001d\u0010\u0097\u0001\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H&J\u001b\u0010\u0098\u0001\u001a\u00020\u00072\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0006\u0010\u0011\u001a\u00020\u0012H&J,\u0010\u009b\u0001\u001a\u00020\u00072\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0006\u0010\u0011\u001a\u00020\u00122\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0003\u0010\u009d\u0001J\u001f\u0010\u009e\u0001\u001a\u00020\u00072\b\u0010\u009f\u0001\u001a\u00030\u009a\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H&J\u0014\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010¤\u0001\u001a\u00020\u0007H\u0016JG\u0010¥\u0001\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\n\u0010¦\u0001\u001a\u0005\u0018\u00010\u0086\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010@\u001a\u00020A2\n\b\u0002\u0010§\u0001\u001a\u00030¨\u00012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0003H\u0016J\u0092\u0001\u0010©\u0001\u001a\u00020\u00072\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010ª\u0001\u001a\u00020\u00122\f\b\u0002\u0010\u008c\u0001\u001a\u0005\u0018\u00010«\u00012\u000b\b\u0002\u0010¬\u0001\u001a\u0004\u0018\u00010\u00032\t\b\u0002\u0010\u00ad\u0001\u001a\u00020\u00142\b\b\u0002\u0010B\u001a\u00020\u00032\t\b\u0002\u0010®\u0001\u001a\u00020\u00032\u000b\b\u0002\u0010¯\u0001\u001a\u0004\u0018\u00010\u00032\f\b\u0002\u0010°\u0001\u001a\u0005\u0018\u00010±\u00012\u000b\b\u0002\u0010²\u0001\u001a\u0004\u0018\u00010\u00032\u000b\b\u0002\u0010³\u0001\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0003\u0010´\u0001J*\u0010µ\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001e2\u0013\u0010¶\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030/H&J\t\u0010·\u0001\u001a\u00020\u000eH&J+\u0010¸\u0001\u001a\u00020\u00072\u0007\u0010¹\u0001\u001a\u00020\u000e2\u0017\b\u0002\u0010º\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0018\u00010.H&J\u0014\u0010»\u0001\u001a\u00020\u00072\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010½\u0001\u001a\u00020\u00072\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u0003H&J\u0011\u0010¾\u0001\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0012\u0010¿\u0001\u001a\u00020\u00072\u0007\u0010À\u0001\u001a\u00020\u0012H&J\u0012\u0010Á\u0001\u001a\u00020\u00072\u0007\u0010ª\u0001\u001a\u00020\u0012H&J\u001b\u0010Â\u0001\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\b\u0010 \u0001\u001a\u00030¡\u0001H&J\u001b\u0010Ã\u0001\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\b\u0010¶\u0001\u001a\u00030Ä\u0001H&J\u0012\u0010Å\u0001\u001a\u00020\u00072\u0007\u0010ª\u0001\u001a\u00020\u0012H&J4\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u00012\r\u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140,2\u0007\u0010É\u0001\u001a\u00020\u00142\u0007\u0010Ê\u0001\u001a\u00020\u0003H¦@¢\u0006\u0003\u0010Ë\u0001J(\u0010Ì\u0001\u001a\u00020\u00072\t\u0010Í\u0001\u001a\u0004\u0018\u00010\u00032\u0007\u0010Î\u0001\u001a\u00020\u00032\t\b\u0002\u0010Ï\u0001\u001a\u00020\u000bH&J\"\u0010Ð\u0001\u001a\u00020\u00072\u0007\u0010Ñ\u0001\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H&J\u0013\u0010Ò\u0001\u001a\u00020\u00072\b\u0010Ó\u0001\u001a\u00030Ô\u0001H&J\u0013\u0010Õ\u0001\u001a\u00020\u00072\b\u0010Ó\u0001\u001a\u00030Ô\u0001H&J1\u0010Ö\u0001\u001a\u00020\u00072\u0007\u0010ª\u0001\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u00032\u0007\u0010×\u0001\u001a\u00020\u000e2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010Ø\u0001\u001a\u00020\u00072\u0007\u0010Ù\u0001\u001a\u00020\u000eH&J\u0012\u0010Ú\u0001\u001a\u00020\u00072\u0007\u0010Û\u0001\u001a\u00020\u0003H&J:\u0010Ü\u0001\u001a\u00020\u00072\b\u0010¦\u0001\u001a\u00030\u0086\u00012\b\u0010Ý\u0001\u001a\u00030Þ\u00012\b\u0010ß\u0001\u001a\u00030à\u00012\u0007\u0010á\u0001\u001a\u00020\u00122\b\u0010â\u0001\u001a\u00030ã\u0001H&J\u0082\u0001\u0010ä\u0001\u001a\u00030å\u00012\u0007\u0010á\u0001\u001a\u00020\u00122\n\u0010æ\u0001\u001a\u0005\u0018\u00010ç\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u00012\t\b\u0002\u0010ê\u0001\u001a\u00020\u000e2\u0011\b\u0002\u0010ë\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001092\u0011\b\u0002\u0010ì\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001092\u0011\b\u0002\u0010í\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001092\u0011\b\u0002\u0010î\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u000109H&J\u001e\u0010ï\u0001\u001a\u00030ð\u00012\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0005H&J\u0086\u0001\u0010ñ\u0001\u001a\u00030ò\u00012\b\u0010¦\u0001\u001a\u00030\u0086\u00012\b\u0010ó\u0001\u001a\u00030ô\u00012\b\u0010æ\u0001\u001a\u00030ç\u00012\t\u0010õ\u0001\u001a\u0004\u0018\u00010\u00012\n\u0010ö\u0001\u001a\u0005\u0018\u00010à\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u00012\u0007\u0010á\u0001\u001a\u00020\u00122\r\u0010÷\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012092\u0007\u0010¯\u0001\u001a\u00020\u000e2\f\b\u0002\u0010ø\u0001\u001a\u0005\u0018\u00010ù\u00012\n\b\u0002\u0010§\u0001\u001a\u00030¨\u0001H&J+\u0010ú\u0001\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\u0010¦\u0001\u001a\u0005\u0018\u00010\u0086\u00012\n\b\u0002\u0010§\u0001\u001a\u00030¨\u0001H\u0016J\t\u0010û\u0001\u001a\u00020\u000eH\u0016J\u0013\u0010ü\u0001\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J3\u0010ý\u0001\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\n\u0010¦\u0001\u001a\u0005\u0018\u00010\u0086\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010§\u0001\u001a\u00030¨\u0001H\u0016J\n\u0010þ\u0001\u001a\u00030ÿ\u0001H&J\u0014\u0010\u0080\u0002\u001a\u0005\u0018\u00010\u0081\u00022\u0006\u0010\u0011\u001a\u00020\u0012H&JB\u0010\u0082\u0002\u001a\u00030\u0083\u00022\u001f\u0010\u0084\u0002\u001a\u001a\u0012\u0005\u0012\u00030\u0086\u0002\u0018\u00010\u0085\u0002j\f\u0012\u0005\u0012\u00030\u0086\u0002\u0018\u0001`\u0087\u00022\t\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0089\u0002\u001a\u0005\u0018\u00010¡\u0001H&J\n\u0010\u008a\u0002\u001a\u00030\u0086\u0001H&J\n\u0010\u008b\u0002\u001a\u00030\u008c\u0002H&J'\u0010\u008d\u0002\u001a\u00020\u00072\b\u0010\u009f\u0001\u001a\u00030\u009a\u00012\b\u0010\u008e\u0002\u001a\u00030\u008f\u00022\b\u0010\u0090\u0002\u001a\u00030\u0091\u0002H&¨\u0006\u0093\u0002"}, d2 = {"Lcom/larus/platform/spi/IAIChatService;", "", "getSocialChatType", "", "cov", "Lcom/larus/im/bean/conversation/Conversation;", "onAsrRecError", "", DBDefinition.TASK_ID, "path", "audioDuration", "", "vid", "insertMultiQuestionReference", "", "extra", "", "message", "Lcom/larus/im/bean/message/Message;", "searchIndex", "", "scene", "isReferenceAction", "getSelectIndex", RemoteMessageConst.MSGID, "onUpdateMessage", "convId", "tryBreakMusic", "getDeepResearchParamsToSend", "map", "", "hasSubBenefitsFromStore", "sendTextOnClickMsgLink", "content", "cvsId", "botId", "extras", "selectMsgIdsFromChatPage", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "schema", "pageMode", "enterMethod", "selectedMsgIds", "", "callback", "Lkotlin/Function1;", "Lkotlin/Pair;", "Lkotlin/ParameterName;", "name", "msgInfoList", "callMapSelectDialog", "latitude", "", "longitude", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "clickCallBack", "Lkotlin/Function0;", "shouldSwitchToSpeakState", "shouldDisableAudioInput", "inputStatusByExperiment", "enableActionSpeech", "activity", "Landroidx/fragment/app/FragmentActivity;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "conversationId", "showOnSpeakText", "createBotAvatarViewerDialog", "Landroid/app/Dialog;", "avatarUrl", "canEditAvatar", "autoLogEnterPage", "from", "uploadPicClickListener", "autoGenBtnClickListener", "convertColorBySL", "color", "valueS", "", "valueL", "getBotSettingTrace", "Lcom/larus/bmhome/setting/IBotSettingTrace;", "createUgcVoiceUtils", "Lcom/larus/voice_setting/ICreateUgcVoiceUtils;", "getMixTracer", "Lcom/larus/voice_setting/voice/mix/IMixTracer;", "getChatImmerseUtil", "Lcom/larus/bmhome/chat/immerse/IChatImmerseUtil;", "getMessageShowRecord", "Lcom/larus/bmhome/chat/adapter/IMessageShowRecord;", "getGlobalNickNameHelper", "Lcom/larus/bmhome/bot/utils/IGlobalNickNameHelper;", "createTipOffDialog", "Lcom/larus/bmhome/tipoff/BaseTipOffDialog;", "params", "Lcom/larus/bmhome/tipoff/TipOffDialogParams;", "refreshValidVoiceItemText", "voiceItem", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "speakerVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "muted", "isRefreshByVoiceOnly", "refreshVoiceItemText", "botEditPos", "Lcom/larus/platform/model/EditPos;", "getContentWithTextTagInfo", "getBotIdList", "conversation", "(Lcom/larus/im/bean/conversation/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAsrMainBotLanguage", "language", "initMarkdownResolver", "clearCachedTopic", "loadTccPromptTopic", "", "()[Ljava/lang/String;", "getAllCachedPromptTopic", "setNeedShowChangeIconBtn", "value", "isWelcomeBackMsg", "(Lcom/larus/im/bean/message/Message;)Ljava/lang/Boolean;", "toPromptContent", "Lcom/larus/bmhome/chat/bean/PromptContent;", "getChatType", "botConversationType", "botSourceType", "isOwnBot", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/String;", "showSideNavConversationMenu", "anchor", "Landroid/view/View;", "hostFragment", "Landroidx/fragment/app/Fragment;", "conversationData", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "clickFrom", "currentPage", "previousPage", "recommendFrom", "getCustomDataHandlers", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "getCustomImgHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "getCustomCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "getCitationHandler", "Lcom/larus/business/markdown/api/citation/ICitationHandler;", "setUserBreakMsgId", "getUserBreakMsgId", "isUserBreakMsgId", "showDislikeFeedbackDialog", "fm", "Landroidx/fragment/app/FragmentManager;", "showDislikeFeedbackDialogAndReport", "conversationType", "(Landroidx/fragment/app/FragmentManager;Lcom/larus/im/bean/message/Message;Ljava/lang/Integer;)V", "showTtsFeedbackDialog", "fragmentManager", "bundle", "Landroid/os/Bundle;", "createStandaloneTtsMenuItem", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "dismissMessageMenu", "handleStandaloneMessageTtsAction", WidgetService.PARAM_FRAGMENT, "longClickSource", "Lcom/larus/bmhome/chat/layout/holder/helper/LongClickSource;", "showTipOffDialog", "msg", "Lcom/larus/platform/model/RecommendFrom;", "fromPage", "reportSource", "severIndex", "isImmersive", "searchMobSource", "Lcom/larus/platform/model/SearchMobParam;", "commonMobParam", "reportType", "(Landroidx/fragment/app/FragmentManager;Lcom/larus/im/bean/message/Message;Lcom/larus/platform/model/RecommendFrom;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/SearchMobParam;Ljava/lang/String;Ljava/lang/Integer;)V", "messageSendExt", "param", "isExpertCardAutoCollapse", "updateExpertSwitchState", "switch", "listener", "waitAnswerReceiving", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "endAnswerReceiving", "checkIfAuthMessage", "replaceLatestMessage", "chatMessage", "broadcast", "openMainBot", "routeImportedImageToMainBot", "Lcom/larus/bmhome/chat/model/ImportedImageRouteParam;", "onReceiveMsg", "requireAllUserConfig", "Lcom/larus/platform/model/UserConfigResponse;", "configTypes", "reason", "source", "(Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUpdateReceiveMsgTimeline", "localMsgId", "point", "curTime", "onStartSendMsg", "localSendMsgId", "observeRedDotCount", "observer", "Lcom/larus/bmhome/chat/reddot/ConversationRedDotListenerWrapper;", "unObserveRedDotCount", "onMsgShowRedDot", "isSocial", "setIsInDoraCall", "inCall", "markImageShown", "uriString", "showMessageMenuBalloon", "recyclerView", "Lcom/larus/bmhome/chat/api/IMessageList;", "menuAnchor", "Lcom/larus/bmhome/view/textview/api/selector/IGestureTextView;", "data", TplType.MENU, "Lcom/larus/bmhome/view/screenmenu/CommonMenu;", "createCodeRenderLongClickHelper", "Landroid/view/View$OnLongClickListener;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "isFromLynx", "onSaveCodeImage", "onFullscreen", "onCopyCode", "onCopyCodeImage", "textCellPopMenuGenerator", "Lcom/larus/bmhome/chat/layout/holder/helper/IPopMenuGroupCreator;", "createMenuTrigger", "Lcom/larus/platform/spi/TextCellMenuTrigger;", "hostView", "Landroidx/recyclerview/widget/RecyclerView;", "markdownView", "anchorView", "childMsgGetter", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "shouldShowDoubaoMessageTtsAction", "isDoubaoMessageTtsActionEnabled", "isDoubaoMessageTtsReading", "handleDoubaoMessageTtsAction", "getServiceBotCardHelper", "Lcom/larus/bmhome/chat/layout/holder/helper/api/IServiceBotCardHelper;", "getLoadingType", "Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingType;", "newFeedbackDialogFragmentInstance", "Landroidx/fragment/app/DialogFragment;", "metaList", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/auth/FeedbackMeta;", "Lkotlin/collections/ArrayList;", GXTemplateKey.GAIAX_PLACEHOLDER, "extraBundle", "createSettingFragment", "chatCameraCache", "Lcom/larus/platform/spi/IChatCameraCache;", "launchVideoDetail", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "eventParam", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAIChatService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f365899a = null;

    @Metadata(d1 = {"\u0000ð\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J9\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u0096\u0001J#\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0097\u0001JU\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u000f2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H\u0096\u0001Jm\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020#2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H\u0096\u0001Jo\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010+\u001a\u00020,2\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010*\u001a\u00020\u00072\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010?\u001a\u00020#2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020CH\u0096\u0001J\t\u0010D\u001a\u000207H\u0096\u0001J\u0013\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0096\u0001J\t\u0010K\u001a\u00020LH\u0096\u0001J\t\u0010M\u001a\u00020\u0005H\u0096\u0001J'\u0010N\u001a\u00020#2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0013\u0010R\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u000f0UH\u0096\u0001J \u0010V\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010U2\b\u0010W\u001a\u0004\u0018\u00010XH\u0096A¢\u0006\u0002\u0010YJ\t\u0010Z\u001a\u00020[H\u0096\u0001J\t\u0010\\\u001a\u00020]H\u0096\u0001J.\u0010^\u001a\u00020\u000f2\n\b\u0001\u0010_\u001a\u0004\u0018\u00010\u00182\n\b\u0001\u0010`\u001a\u0004\u0018\u00010\u00182\u0006\u0010a\u001a\u00020#H\u0096\u0001¢\u0006\u0002\u0010bJ\u000b\u0010c\u001a\u0004\u0018\u00010dH\u0096\u0001J\u0015\u0010e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000b\u0010f\u001a\u0004\u0018\u00010gH\u0096\u0001J\u000f\u0010h\u001a\b\u0012\u0004\u0012\u00020i0UH\u0096\u0001J\u000b\u0010j\u001a\u0004\u0018\u00010kH\u0096\u0001J\u001f\u0010l\u001a\u00020\u00052\u0014\u0010m\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010nH\u0096\u0001J\t\u0010o\u001a\u00020pH\u0096\u0001J\u0013\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J\t\u0010s\u001a\u00020tH\u0096\u0001J\t\u0010u\u001a\u00020vH\u0096\u0001J\u0013\u0010w\u001a\u00020\u00182\b\u0010x\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u0010y\u001a\u00020zH\u0096\u0001J\u0013\u0010{\u001a\u00020\u000f2\b\u0010|\u001a\u0004\u0018\u00010XH\u0096\u0001J\u0013\u0010}\u001a\u00020\u000f2\b\u0010~\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J-\u0010\u007f\u001a\u00020#2\u0006\u0010\t\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u0001072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010B\u001a\u00020CH\u0096\u0001J@\u0010\u0080\u0001\u001a\u00020#2\u0006\u0010\t\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u0001072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010O\u001a\u00020P2\u0006\u0010B\u001a\u00020C2\b\u0010Q\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\n\u0010\u0081\u0001\u001a\u00020#H\u0096\u0001J\n\u0010\u0082\u0001\u001a\u00020\u0005H\u0096\u0001J\n\u0010\u0083\u0001\u001a\u00020\u0018H\u0096\u0001JG\u0010\u0084\u0001\u001a\u00020#2\u0014\u0010\u0085\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0086\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u00182\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000f2\u0007\u0010\u0089\u0001\u001a\u00020#H\u0096\u0001J\n\u0010\u008a\u0001\u001a\u00020#H\u0096\u0001J\u0014\u0010\u008b\u0001\u001a\u00020#2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\n\u0010\u008c\u0001\u001a\u00020#H\u0096\u0001J\u001e\u0010\u008d\u0001\u001a\u00020\u000f2\b\u0010~\u001a\u0004\u0018\u00010\u000f2\b\u0010x\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u001c\u0010\u008e\u0001\u001a\u0004\u0018\u00010#2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0003\u0010\u008f\u0001J(\u0010\u0090\u0001\u001a\u00020\u00052\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0096\u0001J\u0017\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0098\u0001H\u0096\u0001¢\u0006\u0003\u0010\u0099\u0001J\u0013\u0010\u009a\u0001\u001a\u00020\u00052\u0007\u0010\u009b\u0001\u001a\u00020\u000fH\u0096\u0001J,\u0010\u009c\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0n2\u0014\u0010\u009d\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u009e\u0001H\u0096\u0001JC\u0010\u009f\u0001\u001a\u00030 \u00012\u001f\u0010¡\u0001\u001a\u001a\u0012\u0005\u0012\u00030£\u0001\u0018\u00010¢\u0001j\f\u0012\u0005\u0012\u00030£\u0001\u0018\u0001`¤\u00012\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u000f2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0096\u0001J\u0014\u0010¨\u0001\u001a\u00020\u00052\b\u0010©\u0001\u001a\u00030ª\u0001H\u0096\u0001J1\u0010«\u0001\u001a\u00020\u00052\u0007\u0010¬\u0001\u001a\u00020\u000f2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u000f2\b\u0010®\u0001\u001a\u00030¯\u00012\u0007\u0010°\u0001\u001a\u00020\u000fH\u0096\u0001J0\u0010±\u0001\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\t\u0010²\u0001\u001a\u0004\u0018\u00010\u000f2\u0007\u0010³\u0001\u001a\u00020#2\b\u0010W\u001a\u0004\u0018\u00010XH\u0096\u0001J\u0012\u0010´\u0001\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J$\u0010µ\u0001\u001a\u00020\u00052\u0007\u0010¶\u0001\u001a\u00020\u000f2\u0006\u0010~\u001a\u00020\u000f2\u0007\u0010\u0088\u0001\u001a\u00020\u000fH\u0096\u0001J\u001c\u0010·\u0001\u001a\u00020\u00052\u0007\u0010¸\u0001\u001a\u00020\u000f2\u0007\u0010¬\u0001\u001a\u00020\u000fH\u0096\u0001J(\u0010¹\u0001\u001a\u00020\u00052\t\u0010º\u0001\u001a\u0004\u0018\u00010\u000f2\u0007\u0010»\u0001\u001a\u00020\u000f2\b\u0010¼\u0001\u001a\u00030¯\u0001H\u0096\u0001J\u001c\u0010½\u0001\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010¾\u0001\u001a\u00030§\u0001H\u0096\u0001J>\u0010¿\u0001\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020#2\u0007\u0010Å\u0001\u001a\u00020#H\u0096\u0001JJ\u0010Æ\u0001\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u00012\u0007\u0010Ä\u0001\u001a\u00020#2\n\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u00012\u0007\u0010Å\u0001\u001a\u00020#H\u0096\u0001J\u0013\u0010É\u0001\u001a\u00020\u00052\u0007\u0010Ê\u0001\u001a\u00020\u0007H\u0096\u0001J4\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u00012\r\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180U2\u0007\u0010Î\u0001\u001a\u00020\u00182\u0007\u0010Ï\u0001\u001a\u00020\u000fH\u0096A¢\u0006\u0003\u0010Ð\u0001J\u001c\u0010Ñ\u0001\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u009d\u0001\u001a\u00030Ò\u0001H\u0096\u0001J\u0013\u0010Ó\u0001\u001a\u00020\u00052\u0007\u0010Ô\u0001\u001a\u00020\u000fH\u0096\u0001J\u007f\u0010Õ\u0001\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0007\u0010Ö\u0001\u001a\u00020\u000f2\u0006\u0010~\u001a\u00020\u000f2\u0007\u0010×\u0001\u001a\u00020\u00182\u0007\u0010Ø\u0001\u001a\u00020\u000f2\r\u0010Ù\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0U29\u0010Ú\u0001\u001a4\u0012)\u0012'\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u009e\u00010U¢\u0006\u000f\bÜ\u0001\u0012\n\bÝ\u0001\u0012\u0005\b\b(Þ\u0001\u0012\u0004\u0012\u00020\u00050Û\u0001H\u0096\u0001J:\u0010ß\u0001\u001a\u00020\u00052\u0007\u0010à\u0001\u001a\u00020\u000f2\u0006\u0010~\u001a\u00020\u000f2\t\u0010²\u0001\u001a\u0004\u0018\u00010\u000f2\u0007\u0010\u0088\u0001\u001a\u00020\u000f2\t\u0010á\u0001\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0013\u0010â\u0001\u001a\u00020\u00052\u0007\u0010ã\u0001\u001a\u00020#H\u0096\u0001J\u0013\u0010ä\u0001\u001a\u00020\u00052\u0007\u0010å\u0001\u001a\u00020\u000fH\u0096\u0001J\u001e\u0010æ\u0001\u001a\u00020\u00052\b\u0010~\u001a\u0004\u0018\u00010\u000f2\b\u0010x\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\n\u0010ç\u0001\u001a\u00020#H\u0096\u0001J&\u0010è\u0001\u001a\u00020#2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010B\u001a\u00020CH\u0096\u0001J\n\u0010é\u0001\u001a\u00020#H\u0096\u0001J\u001c\u0010ê\u0001\u001a\u00020\u00052\b\u0010ë\u0001\u001a\u00030\u0092\u00012\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J-\u0010ì\u0001\u001a\u00020\u00052\b\u0010ë\u0001\u001a\u00030\u0092\u00012\u0006\u0010\u0015\u001a\u00020\u00072\t\u0010í\u0001\u001a\u0004\u0018\u00010\u0018H\u0096\u0001¢\u0006\u0003\u0010î\u0001J7\u0010ï\u0001\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\b\u0010ð\u0001\u001a\u00030ñ\u00012\u0007\u0010ò\u0001\u001a\u00020=2\u0006\u0010*\u001a\u00020\u00072\b\u0010ó\u0001\u001a\u00030ô\u0001H\u0096\u0001J(\u0010õ\u0001\u001a\u00020#2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010\u000fH\u0096\u0001JS\u0010ö\u0001\u001a\u00020#2\b\u0010÷\u0001\u001a\u00030ø\u00012\u0007\u0010ù\u0001\u001a\u0002072\b\u0010ú\u0001\u001a\u00030û\u00012\t\u0010ü\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010ý\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010þ\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u007f\u0010\u0080\u0002\u001a\u00020\u00052\b\u0010ë\u0001\u001a\u00030\u0092\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010ÿ\u0001\u001a\u0005\u0018\u00010\u0081\u00022\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u000f2\u0007\u0010\u0083\u0002\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u000f2\u0007\u0010\u0084\u0002\u001a\u00020\u000f2\b\u0010?\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0085\u0002\u001a\u0005\u0018\u00010\u0086\u00022\t\u0010\u0087\u0002\u001a\u0004\u0018\u00010\u000f2\t\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0018H\u0096\u0001¢\u0006\u0003\u0010\u0089\u0002J \u0010\u008a\u0002\u001a\u00020\u00052\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\n\u0010¾\u0001\u001a\u0005\u0018\u00010§\u0001H\u0096\u0001J\u001d\u0010\u008b\u0002\u001a\u00030\u008c\u00022\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010W\u001a\u0004\u0018\u00010XH\u0096\u0001J\u0017\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u008e\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\n\u0010\u008f\u0002\u001a\u00020\u0005H\u0096\u0001J\u0014\u0010\u0090\u0002\u001a\u00020\u00052\b\u0010©\u0001\u001a\u00030ª\u0001H\u0096\u0001J+\u0010\u0091\u0002\u001a\u00020\u00052\u0007\u0010\u0092\u0002\u001a\u00020#2\u0016\u0010\u0093\u0002\u001a\u0011\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0005\u0018\u00010Û\u0001H\u0096\u0001J\u0014\u0010\u0094\u0002\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u000fH\u0096\u0001¨\u0006\u0095\u0002"}, d2 = {"Lcom/larus/platform/spi/IAIChatService$Companion;", "Lcom/larus/platform/spi/IAIChatService;", "<init>", "()V", "broadcast", "", "msg", "Lcom/larus/im/bean/message/Message;", "callMapSelectDialog", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "latitude", "", "longitude", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "", "clickCallBack", "Lkotlin/Function0;", "chatCameraCache", "Lcom/larus/platform/spi/IChatCameraCache;", "checkIfAuthMessage", "message", "clearCachedTopic", "convertColorBySL", "", "color", "valueS", "", "valueL", "createBotAvatarViewerDialog", "Landroid/app/Dialog;", "activity", "Landroidx/fragment/app/FragmentActivity;", "avatarUrl", "canEditAvatar", "", "autoLogEnterPage", "from", "uploadPicClickListener", "autoGenBtnClickListener", "createCodeRenderLongClickHelper", "Landroid/view/View$OnLongClickListener;", "data", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "isFromLynx", "onSaveCodeImage", "onFullscreen", "onCopyCode", "onCopyCodeImage", "createMenuTrigger", "Lcom/larus/platform/spi/TextCellMenuTrigger;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "hostView", "Landroidx/recyclerview/widget/RecyclerView;", "markdownView", "", "anchorView", "Lcom/larus/bmhome/view/textview/api/selector/IGestureTextView;", "childMsgGetter", "isImmersive", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "longClickSource", "Lcom/larus/bmhome/chat/layout/holder/helper/LongClickSource;", "createSettingFragment", "createStandaloneTtsMenuItem", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "createTipOffDialog", "Lcom/larus/bmhome/tipoff/BaseTipOffDialog;", "params", "Lcom/larus/bmhome/tipoff/TipOffDialogParams;", "createUgcVoiceUtils", "Lcom/larus/voice_setting/ICreateUgcVoiceUtils;", "dismissMessageMenu", "enableActionSpeech", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "conversationId", "endAnswerReceiving", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "getAllCachedPromptTopic", "", "getBotIdList", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "(Lcom/larus/im/bean/conversation/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBotSettingTrace", "Lcom/larus/bmhome/setting/IBotSettingTrace;", "getChatImmerseUtil", "Lcom/larus/bmhome/chat/immerse/IChatImmerseUtil;", "getChatType", "botConversationType", "botSourceType", "isOwnBot", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/String;", "getCitationHandler", "Lcom/larus/business/markdown/api/citation/ICitationHandler;", "getContentWithTextTagInfo", "getCustomCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "getCustomDataHandlers", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "getCustomImgHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "getDeepResearchParamsToSend", "map", "", "getGlobalNickNameHelper", "Lcom/larus/bmhome/bot/utils/IGlobalNickNameHelper;", "getLoadingType", "Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingType;", "getMessageShowRecord", "Lcom/larus/bmhome/chat/adapter/IMessageShowRecord;", "getMixTracer", "Lcom/larus/voice_setting/voice/mix/IMixTracer;", "getSelectIndex", RemoteMessageConst.MSGID, "getServiceBotCardHelper", "Lcom/larus/bmhome/chat/layout/holder/helper/api/IServiceBotCardHelper;", "getSocialChatType", "cov", "getUserBreakMsgId", "cvsId", "handleDoubaoMessageTtsAction", "handleStandaloneMessageTtsAction", "hasSubBenefitsFromStore", "initMarkdownResolver", "inputStatusByExperiment", "insertMultiQuestionReference", "extra", "", "searchIndex", "scene", "isReferenceAction", "isDoubaoMessageTtsActionEnabled", "isDoubaoMessageTtsReading", "isExpertCardAutoCollapse", "isUserBreakMsgId", "isWelcomeBackMsg", "(Lcom/larus/im/bean/message/Message;)Ljava/lang/Boolean;", "launchVideoDetail", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "eventParam", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "loadTccPromptTopic", "", "()[Ljava/lang/String;", "markImageShown", "uriString", "messageSendExt", "param", "Lkotlin/Pair;", "newFeedbackDialogFragmentInstance", "Landroidx/fragment/app/DialogFragment;", "metaList", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/auth/FeedbackMeta;", "Lkotlin/collections/ArrayList;", GXTemplateKey.GAIAX_PLACEHOLDER, "extraBundle", "Landroid/os/Bundle;", "observeRedDotCount", "observer", "Lcom/larus/bmhome/chat/reddot/ConversationRedDotListenerWrapper;", "onAsrRecError", DBDefinition.TASK_ID, "path", "audioDuration", "", "vid", "onMsgShowRedDot", "botId", "isSocial", "onReceiveMsg", "onStartSendMsg", "localSendMsgId", "onUpdateMessage", "convId", "onUpdateReceiveMsgTimeline", "localMsgId", "point", "curTime", "openMainBot", "bundle", "refreshValidVoiceItemText", "voiceItem", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "speakerVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "muted", "isRefreshByVoiceOnly", "refreshVoiceItemText", "botEditPos", "Lcom/larus/platform/model/EditPos;", "replaceLatestMessage", "chatMessage", "requireAllUserConfig", "Lcom/larus/platform/model/UserConfigResponse;", "configTypes", "reason", "source", "(Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "routeImportedImageToMainBot", "Lcom/larus/bmhome/chat/model/ImportedImageRouteParam;", "saveAsrMainBotLanguage", "language", "selectMsgIdsFromChatPage", "schema", "pageMode", "enterMethod", "selectedMsgIds", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "msgInfoList", "sendTextOnClickMsgLink", "content", "extras", "setIsInDoraCall", "inCall", "setNeedShowChangeIconBtn", "value", "setUserBreakMsgId", "shouldDisableAudioInput", "shouldShowDoubaoMessageTtsAction", "shouldSwitchToSpeakState", "showDislikeFeedbackDialog", "fm", "showDislikeFeedbackDialogAndReport", "conversationType", "(Landroidx/fragment/app/FragmentManager;Lcom/larus/im/bean/message/Message;Ljava/lang/Integer;)V", "showMessageMenuBalloon", "recyclerView", "Lcom/larus/bmhome/chat/api/IMessageList;", "menuAnchor", TplType.MENU, "Lcom/larus/bmhome/view/screenmenu/CommonMenu;", "showOnSpeakText", "showSideNavConversationMenu", "anchor", "Landroid/view/View;", "hostFragment", "conversationData", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "clickFrom", "currentPage", "previousPage", "recommendFrom", "showTipOffDialog", "Lcom/larus/platform/model/RecommendFrom;", "fromPage", "reportSource", "severIndex", "searchMobSource", "Lcom/larus/platform/model/SearchMobParam;", "commonMobParam", "reportType", "(Landroidx/fragment/app/FragmentManager;Lcom/larus/im/bean/message/Message;Lcom/larus/platform/model/RecommendFrom;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/SearchMobParam;Ljava/lang/String;Ljava/lang/Integer;)V", "showTtsFeedbackDialog", "textCellPopMenuGenerator", "Lcom/larus/bmhome/chat/layout/holder/helper/IPopMenuGroupCreator;", "toPromptContent", "Lcom/larus/bmhome/chat/bean/PromptContent;", "tryBreakMusic", "unObserveRedDotCount", "updateExpertSwitchState", "switch", "listener", "waitAnswerReceiving", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IAIChatService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f365900c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IAIChatService f365901b;

        static {
            f365900c = new Companion();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final Map<String, String> A7(Pair<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            return this.f365901b.A7(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final LoadingType B7(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            return this.f365901b.B7(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final View.OnLongClickListener C7(Message r110, q0 r111, q0.a r112, boolean r113, f r114, g r115, h r116, i r117) {
            Intrinsics.checkNotNullParameter(r110, "data");
            return this.f365901b.C7(r110, r111, r112, r113, r114, r115, r116, r117);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void D7(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f365901b.D7(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final Boolean E7(Message r100) {
            return this.f365901b.E7(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final boolean F7(Map<String, String> r100, Message r101, int r110, String r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r100, "extra");
            return this.f365901b.F7(r100, r101, r110, r111, r112);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final e0 G7(Fragment r110, RecyclerView r111, q0 r112, Object r113, st8.a r114, q0.a r115, Message r210, Function0<Message> r211, boolean r212, l r213, LongClickSource r214) {
            Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r111, "hostView");
            Intrinsics.checkNotNullParameter(r112, "adapter");
            Intrinsics.checkNotNullParameter(r210, "data");
            Intrinsics.checkNotNullParameter(r211, "childMsgGetter");
            Intrinsics.checkNotNullParameter(r214, "longClickSource");
            return this.f365901b.G7(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void H7(FragmentManager r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "fm");
            Intrinsics.checkNotNullParameter(r101, "message");
            this.f365901b.H7(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void I7(Fragment r100, b0 r101, st8.a r110, Message r111, CommonMenu r112) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r101, "recyclerView");
            Intrinsics.checkNotNullParameter(r110, "menuAnchor");
            Intrinsics.checkNotNullParameter(r111, "data");
            Intrinsics.checkNotNullParameter(r112, TplType.MENU);
            this.f365901b.I7(r100, r101, r110, r111, r112);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final boolean J7() {
            return this.f365901b.J7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void K7(FragmentManager r100, nr9.g r101, c4 r102) {
            Intrinsics.checkNotNullParameter(r100, "fragmentManager");
            Intrinsics.checkNotNullParameter(r101, "videoPlayData");
            Intrinsics.checkNotNullParameter(r102, "eventParam");
            this.f365901b.K7(r100, r101, r102);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final PromptContent L7(Message r100) {
            return this.f365901b.L7(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void M7(Context r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "bundle");
            this.f365901b.M7(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final boolean N7(FragmentActivity r100, BotModel r101, String r102) {
            return this.f365901b.N7(r100, r101, r102);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final t0 O7(Message r100, e r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            return this.f365901b.O7(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final boolean P7(Message r100, Fragment r101, LongClickSource r102) {
            Intrinsics.checkNotNullParameter(r102, "longClickSource");
            return this.f365901b.P7(r100, r101, r102);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final boolean Q7(FragmentActivity r100, BotModel r101, String r102) {
            return this.f365901b.Q7(r100, r101, r102);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final Fragment R7() {
            return this.f365901b.R7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final boolean S7(Context r100, Fragment r110, Message r111, BotModel r112, LongClickSource r113, String r114) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r112, "botModel");
            Intrinsics.checkNotNullParameter(r113, "longClickSource");
            return this.f365901b.S7(r100, r110, r111, r112, r113, r114);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final String T7(Message r100) {
            return this.f365901b.T7(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final String U7(e r100) {
            return this.f365901b.U7(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final boolean V7() {
            return this.f365901b.V7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void W7(FragmentManager r110, Message r111, RecommendFrom r112, String r113, int r114, String r115, String r210, String r211, SearchMobParam r212, String r213, Integer r214) {
            Intrinsics.checkNotNullParameter(r110, "fm");
            Intrinsics.checkNotNullParameter(r111, "msg");
            Intrinsics.checkNotNullParameter(r115, "conversationId");
            Intrinsics.checkNotNullParameter(r210, "severIndex");
            this.f365901b.W7(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void X7() {
            this.f365901b.X7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final j Y7() {
            return this.f365901b.Y7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void Z7(Context r110, String r111, String r112, int r113, String r114, List r115, v r116) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "schema");
            Intrinsics.checkNotNullParameter(r112, "cvsId");
            Intrinsics.checkNotNullParameter(r114, "enterMethod");
            Intrinsics.checkNotNullParameter(r115, "selectedMsgIds");
            Intrinsics.checkNotNullParameter(r116, "callback");
            this.f365901b.Z7(r110, r111, r112, r113, r114, r115, r116);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final List<com.larus.business.markdown.api.depend.a> a() {
            return this.f365901b.a();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final String[] a8() {
            return this.f365901b.a8();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final b b() {
            return this.f365901b.b();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void b8(String r100) {
            this.f365901b.b8(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "convId");
            Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
            this.f365901b.c(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void c8(String r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r101, "point");
            this.f365901b.c8(r100, r101, r102);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final int d(String r100) {
            return this.f365901b.d(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void d8() {
            this.f365901b.d8();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final jw8.a e() {
            return this.f365901b.e();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final String e7(String r100) {
            return this.f365901b.e7(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final boolean e8(Context r100, Fragment r101, Message r102, LongClickSource r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r103, "longClickSource");
            return this.f365901b.e8(r100, r101, r102, r103);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void f(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f365901b.f(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final v2a.b f7() {
            return this.f365901b.f7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final ot8.a f8(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            return this.f365901b.f8(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final String g(@BotConversationType Integer r100, @BotSourceType Integer r101, boolean r102) {
            return this.f365901b.g(r100, r101, r102);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void g7(Context r100, ItemTextArrow r101, SpeakerVoice r102, boolean r103) {
            this.f365901b.g7(r100, r101, r102, r103);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final BaseTipOffDialog g8(TipOffDialogParams r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            return this.f365901b.g8(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final com.larus.business.markdown.api.extplugin.image.a h() {
            return this.f365901b.h();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final boolean h7() {
            return this.f365901b.h7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void h8(boolean r100) {
            this.f365901b.h8(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void i7(Map<String, String> r100) {
            this.f365901b.i7(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void i8(String r100) {
            this.f365901b.i8(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void j7() {
            this.f365901b.j7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final j0 j8() {
            return this.f365901b.j8();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final DialogFragment k7(ArrayList<FeedbackMeta> r100, String r101, Bundle r102) {
            return this.f365901b.k7(r100, r101, r102);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final com.larus.bmhome.setting.b k8() {
            return this.f365901b.k8();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final c l7() {
            return this.f365901b.l7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void l8(String r100, String r101, String r110, String r111, String r112) {
            Intrinsics.checkNotNullParameter(r100, "content");
            Intrinsics.checkNotNullParameter(r101, "cvsId");
            Intrinsics.checkNotNullParameter(r111, "scene");
            this.f365901b.l8(r100, r101, r110, r111, r112);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void m4(String r100, String r101) {
            this.f365901b.m4(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void m7(String r100, String r101, long r110, String r111) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r111, "vid");
            this.f365901b.m7(r100, r101, r110, r111);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void m8(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "localSendMsgId");
            Intrinsics.checkNotNullParameter(r101, "cvsId");
            Intrinsics.checkNotNullParameter(ObricActionBarTrackType.SPEAK, "scene");
            this.f365901b.m8(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void n4() {
            this.f365901b.n4();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void n7(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uriString");
            this.f365901b.n7(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final boolean n8() {
            return this.f365901b.n8();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void o4(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f365901b.o4(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final cf8.a o7() {
            return this.f365901b.o7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final List<String> p7() {
            return this.f365901b.p7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void q7(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "chatMessage");
            this.f365901b.q7(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final boolean q8() {
            return this.f365901b.q8();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final boolean r7(Message r100) {
            return this.f365901b.r7(r100);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final Object s7(e r100, Continuation<? super List<String>> r101) {
            return this.f365901b.s7(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void t7(boolean r100, Function1<? super Boolean, Unit> r101) {
            this.f365901b.t7(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final p2a.a u7() {
            return this.f365901b.u7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final d v7() {
            return this.f365901b.v7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final int w7() {
            return this.f365901b.w7();
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final Dialog x7(FragmentActivity r100, String r110, boolean r111, String r112, Function0 r113, Function0 r114) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r110, "avatarUrl");
            return this.f365901b.x7(r100, r110, r111, r112, r113, r114);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void y7(Context r110, double r111, double r112, String r113, Function0<Unit> r114) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r113, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
            this.f365901b.y7(r110, r111, r112, r113, r114);
        }

        @Override // com.larus.platform.spi.IAIChatService
        public final void z7(Context r100, ItemTextArrow r101, SpeakerVoice r110, boolean r111, EditPos r112, boolean r113) {
            this.f365901b.z7(r100, r101, r110, r111, r112, r113);
        }

        private Companion() {
            IAIChatService r100 = (IAIChatService) ServiceManager.get().getService(IAIChatService.class);
            if (r100 != null) goto L5;
            r100 = new AIChatServiceNoop();
        L5:
            this.f365901b = r100;
        }
    }

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ void b(Companion r110, FragmentManager r111, Message r112, String r113, String r114, String r115, Integer r116, int r210) {
            if ((r210 & 8) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r210 & 32) == 0) goto L9;
            String r101 = "";
        L11:
            if ((r210 & 64) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r210 & 1024) == 0) goto L17;
            Integer r117 = null;
        L18:
            r110.W7(r111, r112, null, r100, 0, r101, r102, null, null, null, r117);
            return;
        L17:
            r117 = r116;
            goto L18
        L13:
            r102 = r115;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }

        public static /* synthetic */ e0 a(Companion r110, Fragment r111, RecyclerView r112, q0 r113, Object r114, st8.a r115, q0.a r116, Message r117, Function0 r210, boolean r211, LongClickSource r212, int r213) {
            if ((r213 & 1024) == 0) goto L5;
            LongClickSource r118 = LongClickSource.Content;
        L7:
            return r110.G7(r111, r112, r113, r114, r115, r116, r117, r210, r211, null, r118);
        L5:
            r118 = r212;
            goto L7
        }
    }

    static {
        f365899a = Companion.f365900c;
    }

    Map<String, String> A7(Pair<String, String> r100);

    LoadingType B7(Message r100);

    View.OnLongClickListener C7(Message r100, q0 r101, q0.a r102, boolean r103, f r104, g r105, h r106, i r107);

    void D7(Message r100);

    Boolean E7(Message r100);

    boolean F7(Map<String, String> r100, Message r101, int r102, String r103, boolean r104);

    e0 G7(Fragment r100, RecyclerView r101, q0 r102, Object r103, st8.a r104, q0.a r105, Message r106, Function0<Message> r107, boolean r108, l r110, LongClickSource r111);

    void H7(FragmentManager r100, Message r101);

    void I7(Fragment r100, b0 r101, st8.a r102, Message r103, CommonMenu r104);

    boolean J7();

    void K7(FragmentManager r100, nr9.g r101, c4 r102);

    PromptContent L7(Message r100);

    void M7(Context r100, Bundle r101);

    boolean N7(FragmentActivity r100, BotModel r101, String r102);

    t0 O7(Message r100, e r101);

    boolean P7(Message r100, Fragment r101, LongClickSource r102);

    boolean Q7(FragmentActivity r100, BotModel r101, String r102);

    Fragment R7();

    boolean S7(Context r100, Fragment r101, Message r102, BotModel r103, LongClickSource r104, String r105);

    String T7(Message r100);

    String U7(e r100);

    boolean V7();

    void W7(FragmentManager r100, Message r101, RecommendFrom r102, String r103, int r104, String r105, String r106, String r107, SearchMobParam r108, String r110, Integer r111);

    void X7();

    j Y7();

    void Z7(Context r100, String r101, String r102, int r103, String r104, List r105, v r106);

    List<com.larus.business.markdown.api.depend.a> a();

    String[] a8();

    b b();

    void b8(String r100);

    void c(String r100, String r101);

    void c8(String r100, String r101, long r102);

    int d(String r100);

    void d8();

    jw8.a e();

    String e7(String r100);

    boolean e8(Context r100, Fragment r101, Message r102, LongClickSource r103);

    void f(Message r100);

    v2a.b f7();

    ot8.a f8(Message r100);

    String g(@BotConversationType Integer r100, @BotSourceType Integer r101, boolean r102);

    void g7(Context r100, ItemTextArrow r101, SpeakerVoice r102, boolean r103);

    BaseTipOffDialog g8(TipOffDialogParams r100);

    com.larus.business.markdown.api.extplugin.image.a h();

    boolean h7();

    void h8(boolean r100);

    void i7(Map<String, String> r100);

    void i8(String r100);

    void j7();

    j0 j8();

    DialogFragment k7(ArrayList<FeedbackMeta> r100, String r101, Bundle r102);

    com.larus.bmhome.setting.b k8();

    c l7();

    void l8(String r100, String r101, String r102, String r103, String r104);

    void m4(String r100, String r101);

    void m7(String r100, String r101, long r102, String r103);

    void m8(String r100, String r101);

    void n4();

    void n7(String r100);

    boolean n8();

    void o4(Message r100);

    cf8.a o7();

    List<String> p7();

    void q7(Message r100);

    boolean q8();

    boolean r7(Message r100);

    Object s7(e r100, Continuation<? super List<String>> r101);

    void t7(boolean r100, Function1<? super Boolean, Unit> r101);

    p2a.a u7();

    d v7();

    int w7();

    Dialog x7(FragmentActivity r100, String r101, boolean r102, String r103, Function0 r104, Function0 r105);

    void y7(Context r100, double r101, double r102, String r103, Function0<Unit> r104);

    void z7(Context r100, ItemTextArrow r101, SpeakerVoice r102, boolean r103, EditPos r104, boolean r105);
}
