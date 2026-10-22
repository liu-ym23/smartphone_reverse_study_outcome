package com.bytedance.ee.bear.middleground.comment.adapter;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.export.CommentDiffUtils;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentAction;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.RevisionExtra;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyData;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.comment.extension.events.CardAdapterActionType;
import com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTimeText;
import com.bytedance.ee.bear.middleground.comment.widget.RichTextInjector;
import com.bytedance.ee.bear.middleground.comment.widget.SmartReplyPreview;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 Á\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\fÁ\u0001Â\u0001Ã\u0001Ä\u0001Å\u0001Æ\u0001BW\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J \u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\b2\u0006\u0010`\u001a\u00020H2\u0006\u00105\u001a\u00020HH\u0002J\u0012\u0010a\u001a\u00020T2\b\u0010b\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010c\u001a\u00020\u00142\u0006\u0010d\u001a\u00020\u001eH\u0016J\u0010\u0010e\u001a\u00020\u00142\u0006\u0010f\u001a\u00020%H\u0016J\n\u0010g\u001a\u0004\u0018\u00010 H\u0016J\b\u0010h\u001a\u00020%H\u0016J\u000e\u0010i\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0018\u0010j\u001a\u00020\u00022\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020HH\u0016J\b\u0010n\u001a\u00020HH\u0016J\u0010\u0010o\u001a\u00020H2\u0006\u00105\u001a\u00020HH\u0016J&\u0010p\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u00022\u0006\u00105\u001a\u00020H2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020:0\"H\u0016J\u001c\u0010s\u001a\u00020\u00142\n\u0010q\u001a\u00060tR\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0002J6\u0010v\u001a\u00020\u00142\n\u0010q\u001a\u00060tR\u00020\u00002\u0006\u0010w\u001a\u00020T2\u0006\u0010x\u001a\u00020H2\u0006\u0010y\u001a\u00020H2\b\u0010z\u001a\u0004\u0018\u00010{H\u0002J$\u0010|\u001a\u00020\u00142\n\u0010q\u001a\u00060tR\u00020\u00002\u0006\u0010u\u001a\u00020#2\u0006\u00105\u001a\u00020HH\u0014J<\u0010}\u001a\u00020\u00142\n\u0010q\u001a\u00060tR\u00020\u00002\u0006\u0010u\u001a\u00020#2\u0006\u0010~\u001a\u00020\u00032\u0006\u00105\u001a\u00020H2\u000e\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u001d\u0010\u0080\u0001\u001a\u00020\u00142\n\u0010q\u001a\u00060tR\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0002J\t\u0010\u0081\u0001\u001a\u00020\u0014H\u0014J\u0018\u0010p\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u00022\u0006\u00105\u001a\u00020HH\u0017J\u001e\u0010\u0082\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u00105\u001a\u00020HH\u0002J\u001e\u0010\u0084\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0085\u0001R\u00020\u00002\u0006\u00105\u001a\u00020HH\u0002J\"\u0010\u0086\u0001\u001a\f\u0012\u0005\u0012\u00030\u0088\u0001\u0018\u00010\u0087\u00012\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\b¢\u0006\u0003\u0010\u008a\u0001J\u001b\u0010\u008b\u0001\u001a\u00020\u00142\u0007\u0010\u008c\u0001\u001a\u00020H2\u0007\u0010\u008d\u0001\u001a\u00020HH\u0016J\u001e\u0010\u008e\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0014J\u0016\u0010\u008f\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u0000H\u0002J(\u0010\u0090\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0007\u0010\u0091\u0001\u001a\u00020T2\u0007\u0010\u0092\u0001\u001a\u00020TH\u0002J\u001e\u0010\u0093\u0001\u001a\u00020T2\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0002J\t\u0010\u0094\u0001\u001a\u00020TH\u0004J\u001e\u0010\u0095\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0002J\u001e\u0010\u0096\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0002J\u0011\u0010\u0097\u0001\u001a\u00020T2\u0006\u0010u\u001a\u00020#H\u0002J\u001e\u0010\u0098\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0002J\u001e\u0010\u0099\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0014J\u001e\u0010\u009a\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0004J\u001e\u0010\u009b\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0002J\u0011\u0010\u009c\u0001\u001a\u00020T2\u0006\u0010u\u001a\u00020#H\u0002J\u001e\u0010\u009d\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0002J&\u0010\u009e\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#2\u0006\u00105\u001a\u00020HH\u0014J\u001e\u0010\u009f\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0014J\u001e\u0010 \u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0014J\u001e\u0010¡\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0014J&\u0010¢\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#2\u0006\u00105\u001a\u00020HH\u0014J\u001e\u0010£\u0001\u001a\u00020\u00142\u0006\u0010u\u001a\u00020#2\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u0000H\u0004J\u001f\u0010¤\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0007\u0010¥\u0001\u001a\u00020#H\u0014J\u001e\u0010¦\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0014J!\u0010§\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\t\b\u0002\u0010¨\u0001\u001a\u00020HH\u0002J\u0018\u0010©\u0001\u001a\u0004\u0018\u00010#2\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u0000H\u0002J\u0013\u0010ª\u0001\u001a\u00020\u00142\b\u0010«\u0001\u001a\u00030¬\u0001H\u0002J\u0018\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0007\u0010®\u0001\u001a\u00020\bH\u0016J\u0011\u0010¯\u0001\u001a\u00020\b2\u0006\u00105\u001a\u00020HH\u0016J\u000b\u0010°\u0001\u001a\u0004\u0018\u00010\bH\u0016J\u001b\u0010±\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u000109H\u0016J\u0011\u0010²\u0001\u001a\u00020\b2\u0006\u0010u\u001a\u00020#H\u0016J\u0014\u0010³\u0001\u001a\u00020H2\t\u0010¥\u0001\u001a\u0004\u0018\u00010#H\u0016J\u0013\u0010´\u0001\u001a\u00020\u00142\b\u0010«\u0001\u001a\u00030¬\u0001H\u0002J\u001d\u0010µ\u0001\u001a\u00020\u00142\b\u0010¶\u0001\u001a\u00030·\u00012\b\u0010¸\u0001\u001a\u00030¬\u0001H\u0002J\u001e\u0010¹\u0001\u001a\u00020\u00142\u000b\u0010q\u001a\u00070\u0083\u0001R\u00020\u00002\u0006\u0010u\u001a\u00020#H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u000f\u001a\u00020\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020 8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u001c\u00102\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R\u001c\u00105\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R,\u00108\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u001a\u0010G\u001a\u00020HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010J\"\u0004\bO\u0010LR\u001a\u0010P\u001a\u00020HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010J\"\u0004\bR\u0010LR\u001a\u0010S\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010J\"\u0004\b[\u0010LR\u000e\u0010\\\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000RT\u0010º\u0001\u001a7\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\b\u0012\u0005\u0012\u00030¼\u0001\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¼\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020\u00140»\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001¨\u0006Ç\u0001"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/export/ICardAdapter;", "config", "Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "userIds", "", "", "commentListeners", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "actionControl", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "sharePermissionViewModel", "Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;", "cardDataViewModel", "Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "language", "clickLink", "Lkotlin/Function0;", "", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;Ljava/util/List;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getConfig", "()Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "getSharePermissionViewModel", "()Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;", "getCardDataViewModel", "()Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "uiState", "Lcom/bytedance/ee/bear/middleground/comment/export/UiState;", "commentDetails", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "commentBean", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;", "getCommentBean", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;", "setCommentBean", "(Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;)V", "quote", "getQuote", "()Ljava/lang/String;", "setQuote", "(Ljava/lang/String;)V", "parentToken", "getParentToken", "setParentToken", "parentType", "getParentType", "setParentType", "position", "getPosition", "setPosition", "bizParams", "", "", "getBizParams", "()Ljava/util/Map;", "setBizParams", "(Ljava/util/Map;)V", "onResolve", "getOnResolve", "()Lkotlin/jvm/functions/Function0;", "setOnResolve", "(Lkotlin/jvm/functions/Function0;)V", "onClickEmpty", "getOnClickEmpty", "setOnClickEmpty", "imageSize", "", "getImageSize", "()I", "setImageSize", "(I)V", "imageItemMargin", "getImageItemMargin", "setImageItemMargin", "heightFromTop", "getHeightFromTop", "setHeightFromTop", "adminCanPreview", "", "getAdminCanPreview", "()Z", "setAdminCanPreview", "(Z)V", "cardPos", "getCardPos", "setCardPos", "minWidthInWideScreen", "createContentLinkClickListener", "Lcom/bytedance/ee/bear/span/AbsSpan$ISpanClickListener;", "commentId", "visibility", "isSameSpaceInner", ResourceData.KEY_URL, "onAttachedToRecyclerView", "recyclerView", "setData", WikiFolderPushPlugin.DATA, "getUiState", "getData", "getCommentDetails", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "payloads", "bindQuoteText", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$QuoteViewHolder;", "item", "bindCollaboratorIcon", "isPrivate", "drawableRes", "drawableTint", "background", "Landroid/graphics/drawable/Drawable;", "bindQuoteMenu", "showCardMoreMenuList", "cardAdapter", "participantList", "bindRevisionIcon", "updateImageSize", "bindContentViewHolder", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$ContentViewHolder;", "bindRevisionViewHolder", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$RevisionViewHolder;", "getRevisionTextStylesOrNull", "", "Lcom/bytedance/ee/bear/function/TextStyle;", "revisionTitle", "(Ljava/lang/String;)[Lcom/bytedance/ee/bear/function/TextStyle;", "onItemVisible", "first", "last", "setCommentImageList", "checkFilePreviewPermission", "handleFilePreviewPermission", "canPreview", "isShowLoading", "isHolderMatchesItem", "isInEdit", "setRetryView", "setRetryViewForSend", "hasSomeImageLoadFail", "setRetryViewForImageLoad", "setBackGround", "setAvatar", "setProfile", "shouldHideDeleteButton", "setContentLoadingOrFailStatus", "setContent", "setSmartAIReplyPreview", "clickSmartAIReplyPreview", "setTranslateIcon", "setTranslateContent", "setTime", "setReaction", "commentDetail", "setMore", "showReaction", "gravityPrior", "getCommentDetailByHolder", "setReactionTouchT", "view", "Landroid/view/View;", "getLast3Item", "replyId", "findReplyIdByPosition", "getPostion", "getBizParam", "getCommentId", "getCommentVisibility", "adjustTouchArea", "adjustPosition", "textView", "Landroid/widget/TextView;", "tran", "setAnim", "onClickImageItem", "Lkotlin/Function6;", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail$ExtraEntity$CommentImageEntity;", "getOnClickImageItem", "()Lkotlin/jvm/functions/Function6;", "setOnClickImageItem", "(Lkotlin/jvm/functions/Function6;)V", "Companion", "PlaceHolderViewHolder", "QuoteViewHolder", "ContentViewHolder", "RevisionViewHolder", "UnknownViewHolder", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CardAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ICardAdapter {
    public static final int COMMENT_IMAGE_COL_THREE = 3;
    public static final int COMMENT_IMAGE_COL_TWO = 2;
    public static final int COMMENT_IMAGE_COUNT_FOUR = 4;
    public static final float COMMENT_IMAGE_ITEM_MARGIN = 4.0f;
    private static final int COMMENT_IMAGE_OUTER_SPACE_WIDTH = 0;
    private static final int COMMENT_MAX_IMAGE_SIZE = 0;
    public static final a Companion = null;
    public static final String TAG = "Comment#CardAdapter2";
    public static final float TOP_PLACE_HOLDER_FACTOR = 0.4f;
    public static final float TOP_PLACE_HOLDER_VC_FACTOR = 0.2f;
    public static final int TOUCH_DELEGATE_OVER_BOTTOM = 200;
    public static final int TOUCH_DELEGATE_OVER_LEFT = 200;
    public static final int TOUCH_DELEGATE_OVER_RIGHT = 200;
    public static final int TOUCH_DELEGATE_OVER_TOP = 30;
    private final com.bytedance.ee.bear.middleground.comment.control.y actionControl;
    private boolean adminCanPreview;
    private Map<Object, ? extends Object> bizParams;
    private final com.bytedance.ee.bear.middleground.comment.card.d cardDataViewModel;
    private int cardPos;
    private final Function0<Unit> clickLink;
    private CommentBean commentBean;
    protected List<CommentBean.CommentDetail> commentDetails;
    private final com.bytedance.ee.bear.middleground.comment.control.z commentListeners;
    private final com.bytedance.ee.bear.middleground.comment.uitls.p config;
    private int heightFromTop;
    private int imageItemMargin;
    private int imageSize;
    private final String language;
    private RecyclerView mRecyclerView;
    private final int minWidthInWideScreen;
    private Function0<Unit> onClickEmpty;
    private Function6<? super String, ? super Integer, ? super String, ? super CommentBean.CommentDetail.ExtraEntity.CommentImageEntity, ? super List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, ? super CommentBean, Unit> onClickImageItem;
    private Function0<Unit> onResolve;
    private String parentToken;
    private String parentType;
    private String position;
    private String quote;
    private final SharePermissionViewModel sharePermissionViewModel;
    protected com.bytedance.ee.bear.middleground.comment.export.w uiState;
    private final List<String> userIds;

    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0096\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020RJ\u0010\u0010i\u001a\u00020g2\u0006\u0010j\u001a\u00020RH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R\u001a\u00105\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R\u001a\u00108\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010)\"\u0004\b:\u0010+R\u001a\u0010;\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001dR\u001a\u0010>\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010)\"\u0004\b@\u0010+R\u0011\u0010A\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010)R\u0011\u0010C\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u000fR\u0011\u0010E\u001a\u00020F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010I\u001a\u00020J¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010M\u001a\u0004\u0018\u00010N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010Y\u001a\u00020Z¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010T\"\u0004\be\u0010V¨\u0006k"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$ContentViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/BaseContentViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;Landroid/view/View;)V", "translateContent", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "getTranslateContent", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "setTranslateContent", "(Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;)V", "translate", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "getTranslate", "()Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", "setTranslate", "(Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;)V", "userImg", "Landroid/widget/ImageView;", "getUserImg", "()Landroid/widget/ImageView;", "setUserImg", "(Landroid/widget/ImageView;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "setName", "(Landroid/widget/TextView;)V", "crateTime", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTimeText;", "getCrateTime", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTimeText;", "setCrateTime", "(Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTimeText;)V", "content", "getContent", "setContent", "more", "getMore", "()Landroid/view/View;", "setMore", "(Landroid/view/View;)V", "reactionFlowLayout", "Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;", "getReactionFlowLayout", "()Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;", "setReactionFlowLayout", "(Lcom/ss/android/lark/reaction/widget/flowlayout/ReactionFlowLayout;)V", "commentSendingMask", "getCommentSendingMask", "setCommentSendingMask", "contentMask", "getContentMask", "setContentMask", "retry", "getRetry", "setRetry", "sendFailTv", "getSendFailTv", "setSendFailTv", "deleteComment", "getDeleteComment", "setDeleteComment", "holderView", "getHolderView", "commentSending", "getCommentSending", "retryWrapper", "Landroid/view/ViewGroup;", "getRetryWrapper", "()Landroid/view/ViewGroup;", "commentImageListRv", "Landroidx/recyclerview/widget/RecyclerView;", "getCommentImageListRv", "()Landroidx/recyclerview/widget/RecyclerView;", "smartReply", "Lcom/bytedance/ee/bear/middleground/comment/widget/SmartReplyPreview;", "getSmartReply", "()Lcom/bytedance/ee/bear/middleground/comment/widget/SmartReplyPreview;", "spanCount", "", "getSpanCount", "()I", "setSpanCount", "(I)V", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "commentListAdapter", "Lcom/bytedance/ee/bear/middleground/comment/image/CommentImageAdapter;", "getCommentListAdapter", "()Lcom/bytedance/ee/bear/middleground/comment/image/CommentImageAdapter;", "commentDetail", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "getCommentDetail", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "setCommentDetail", "(Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;)V", "hash", "getHash", "setHash", "updateImageRecyclerViewSize", "", "imageCount", "updateLayoutCount", "imageSize", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public class ContentViewHolder extends BaseContentViewHolder {
        public final CommentTextView a;
        public final BearLottieView b;
        public final ImageView c;
        public final TextView d;
        public final CommentTimeText e;
        public final CommentTextView f;
        public final View g;
        public final ReactionFlowLayout h;
        public final View i;
        public final View j;
        public final View k;
        public final TextView l;
        public final View m;
        public final View n;
        public final BearLottieView o;
        public final ViewGroup p;
        public final RecyclerView q;
        public final SmartReplyPreview r;
        public int s;
        public final CommentImageAdapter t;
        public CommentBean.CommentDetail u;
        public final /* synthetic */ CardAdapter2 v;

        public static final class a implements CommentImageAdapter.a {
            public final /* synthetic */ CardAdapter2 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ ContentViewHolder c;

            @Override // com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter.a
            public final void a(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r11) {
                int r1 = 0;
                String r2 = null;
                if (this.a.getConfig().T == true) goto L5;
                boolean r0 = this.a.getAdminCanPreview();
            L13:
                if (r0 == false) goto L33;
                rcb.c.d(this.b);
                CommentBean.CommentDetail r3 = this.c.u;
                if (r3 == null) goto L17;
                r2 = this.a.getCommentId(r3);
            L17:
                CommentBean.CommentDetail r4 = this.c.u;
                if (r4 == null) goto L20;
                r1 = r4.getCommentType();
            L20:
                Function6<String, Integer, String, CommentBean.CommentDetail.ExtraEntity.CommentImageEntity, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, CommentBean, Unit> r5 = this.a.getOnClickImageItem();
                if (r2 != null) goto L23;
                String r6 = "";
            L24:
                Integer r7 = Integer.valueOf(r1);
                CommentBean.CommentDetail r8 = this.c.u;
                if (r8 == null) goto L30;
                String r9 = r8.getReply_id();
                if (r9 == null) goto L30;
                String r10 = r9;
            L31:
                r5.invoke(r6, r7, r10, r11, this.c.t.n, this.a.getCommentBean());
                return;
            L30:
                r10 = "";
                goto L31
            L23:
                r6 = r2;
                goto L24
            L33:
                return;
            L5:
                SharePermissionViewModel r12 = this.a.getSharePermissionViewModel();
                if (r12 == null) goto L8;
                SharePermissionViewModel.PreviewPermissionState r13 = r12.h();
            L10:
                if (r13 != SharePermissionViewModel.PreviewPermissionState.STATE_TRUE) goto L12;
                r0 = true;
                goto L13
            L12:
                r0 = false;
                goto L13
            L8:
                r13 = null;
                goto L10
            }

            public a(CardAdapter2 r1, View r2, ContentViewHolder r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        public static final class b implements View.OnLongClickListener {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View r1) {
                return true;
            }
        }

        public static final class c implements View.OnLayoutChangeListener {
            public final /* synthetic */ CardAdapter2 a;
            public final /* synthetic */ ContentViewHolder b;

            public c(CardAdapter2 r1, ContentViewHolder r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                if (r2 != r6) goto L4;
                if (r4 != r8) goto L4;
                return;
            L4:
                this.a.updateImageSize();
                ContentViewHolder r10 = this.b;
                r10.W3(r10.t.getItemCount());
                this.b.t.notifyDataSetChanged();
            }
        }

        @Override // com.bytedance.ee.bear.middleground.comment.adapter.BaseContentViewHolder
        public final CommentTextView T3() {
            return this.f;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.adapter.BaseContentViewHolder
        public final ReactionFlowLayout U3() {
            return this.h;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.adapter.BaseContentViewHolder
        public final BearLottieView V3() {
            return this.b;
        }

        public final void W3(int r4) {
            if (r4 <= 0) goto L5;
            this.t.b = this.v.getImageSize();
            ViewGroup.LayoutParams r0 = this.q.getLayoutParams();
            int r1 = this.v.getImageSize() + this.v.getImageItemMargin();
            int r2 = this.s;
            r0.height = r1 * (((r4 + r2) - 1) / r2);
            this.q.setLayoutParams(r0);
            return;
        }

        public void X3(int r3) {
            GridLayoutManager r0 = this.q.getLayoutManager();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            GridLayoutManager r1 = r0;
            if (r3 != 4) goto L5;
            int r4 = 2;
        L6:
            r1.setSpanCount(r4);
            return;
        L5:
            r4 = 3;
            goto L6
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [android.widget.TextView, com.bytedance.ee.bear.middleground.comment.widget.CommentTextView] */
        /* JADX WARN: Type inference failed for: r1v14, types: [android.widget.TextView, com.bytedance.ee.bear.middleground.comment.widget.CommentTextView] */
        public ContentViewHolder(final CardAdapter2 r10, View r11) {
            Intrinsics.checkNotNullParameter(r11, "itemView");
            this.v = r10;
            super(r11);
            ?? r0 = (CommentTextView) r11.findViewById(2131390399);
            this.a = r0;
            this.b = r11.findViewById(2131376701);
            this.c = (ImageView) r11.findViewById(2131392043);
            this.d = (TextView) r11.findViewById(2131390975);
            this.e = (CommentTimeText) r11.findViewById(2131390459);
            ?? r1 = (CommentTextView) r11.findViewById(2131390392);
            this.f = r1;
            this.g = r11.findViewById(2131391037);
            this.h = r11.findViewById(2131383754);
            this.i = r11.findViewById(2131367394);
            View r2 = r11.findViewById(2131367839);
            this.j = r2;
            this.k = r11.findViewById(2131367426);
            this.l = (TextView) r11.findViewById(2131367428);
            this.m = r11.findViewById(2131368787);
            this.n = r11.findViewById(2131367320);
            this.o = r11.findViewById(2131367392);
            this.p = (ViewGroup) r11.findViewById(2131384476);
            RecyclerView r3 = r11.findViewById(2131384933);
            this.q = r3;
            this.r = (SmartReplyPreview) r11.findViewById(2131367444);
            this.s = 3;
            RecyclerView.ItemDecoration r5 = new CardAdapter2$ContentViewHolder$itemDecoration$1(r10, this);
            CommentImageAdapter r6 = new CommentImageAdapter();
            this.t = r6;
            hashCode();
            if (r10.getConfig().T == true) goto L5;
            r6.d = r10.getAdminCanPreview();
        L10:
            r6.a = false;
            r6.notifyDataSetChanged();
            r6.k = new a(r10, r11, this);
            r6.b = r10.getImageSize();
            r6.g = r10.getConfig().i;
            r6.h = r10.getConfig().k.b;
            r3.setLayoutManager(new GridLayoutManager(r10.getConfig().getActivity(), 3));
            r3.addItemDecoration(r5);
            if (r10.getConfig().G == false) goto L13;
            LarkFont r12 = LarkFont.BODY2;
            zz7.a.d(r1, r12);
            zz7.a.d(r0, r12);
        L13:
            r2.setOnLongClickListener(b.a);
            if (ForsetiHelper.p() == true) goto L16;
            return;
        L16:
            if (r10.getConfig().n.isAside() == true) goto L20;
            r10.getConfig().c.addOnLayoutChangeListener(new c(r10, this));
            return;
        L20:
            return;
        L5:
            SharePermissionViewModel r7 = r10.getSharePermissionViewModel();
            if (r7 == null) goto L10;
            if (r7.h() != SharePermissionViewModel.PreviewPermissionState.STATE_INIT) goto L10;
            r6.e = true;
            goto L10
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$PlaceHolderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "Companion", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PlaceHolderViewHolder extends RecyclerView.ViewHolder {

        public static final class a {
        }

        static {
        }

        public PlaceHolderViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0096\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0011\u0010\u0017\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$QuoteViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;Landroid/view/View;)V", "collaborator", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "getCollaborator", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "collaboratorIcon", "Landroid/widget/ImageView;", "getCollaboratorIcon", "()Landroid/widget/ImageView;", "divider", "getDivider", "()Landroid/view/View;", "quoteText", "Landroid/widget/TextView;", "getQuoteText", "()Landroid/widget/TextView;", "resolveView", "getResolveView", "moreView", "getMoreView", "menuWrapper", "getMenuWrapper", "acceptRevision", "getAcceptRevision", "setAcceptRevision", "(Landroid/widget/ImageView;)V", "rejectRevision", "getRejectRevision", "setRejectRevision", "revisionContainer", "Landroid/view/ViewGroup;", "getRevisionContainer", "()Landroid/view/ViewGroup;", "setRevisionContainer", "(Landroid/view/ViewGroup;)V", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public class QuoteViewHolder extends RecyclerView.ViewHolder {
        public final LKUIRoundedImageView2 a;
        public final ImageView b;
        public final View c;
        public final TextView d;
        public final ImageView e;
        public final ImageView f;
        public final View g;
        public final ImageView h;
        public final ImageView i;
        public final ViewGroup j;

        public QuoteViewHolder(CardAdapter2 r4, View r5) {
            Intrinsics.checkNotNullParameter(r5, "itemView");
            super(r5);
            this.a = r5.findViewById(2131367316);
            this.b = (ImageView) r5.findViewById(2131367317);
            View r0 = r5.findViewById(2131367319);
            this.c = r0;
            TextView r1 = (TextView) r5.findViewById(2131367324);
            this.d = r1;
            this.e = (ImageView) r5.findViewById(2131367325);
            this.f = (ImageView) r5.findViewById(2131367323);
            this.g = r5.findViewById(2131367322);
            this.h = (ImageView) r5.findViewById(2131361965);
            this.i = (ImageView) r5.findViewById(2131384195);
            this.j = (ViewGroup) r5.findViewById(2131384492);
            if (r4.getConfig().G == false) goto L6;
            LarkFont r6 = LarkFont.BODY2;
            zz7.a.d(r1, r6);
            ViewGroup.LayoutParams r2 = r0.getLayoutParams();
            r2.height = (int) zz7.b.i(r5.getContext(), r6);
            r0.setLayoutParams(r2);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$RevisionViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$ContentViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;Landroid/view/View;)V", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class RevisionViewHolder extends ContentViewHolder {
        public RevisionViewHolder(CardAdapter2 r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            super(r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2$UnknownViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/adapter/CardAdapter2;Landroid/view/View;)V", "userMsgImage", "Landroid/widget/ImageView;", "getUserMsgImage", "()Landroid/widget/ImageView;", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class UnknownViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;

        public UnknownViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131392043);
            r2.setOnClickListener(com.bytedance.ee.bear.middleground.comment.adapter.a.a);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class a0 implements View.OnClickListener {
        public final /* synthetic */ CommentBean.CommentDetail a;
        public final /* synthetic */ CardAdapter2 b;

        public a0(CommentBean.CommentDetail r1, CardAdapter2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.a.isAnonymous() == true) goto L9;
            this.b.getConfig().h.getClass();
            if (com.bytedance.ee.bear.middleground.comment.p.c() == true) goto L10;
            CardAdapter2.access$getCommentListeners$p(this.b).s0().invoke(this.a.getUser_id());
            return;
        L10:
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ QuoteViewHolder b;

        public b(boolean r1, QuoteViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.a == false) goto L6;
            Toast.showText(((RecyclerView.ViewHolder) this.b).itemView.getContext(), UIHelper.getString(2131889014));
            return;
        }
    }

    public static final class b0 implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CardAdapter2 b;
        public final /* synthetic */ CommentBean.CommentDetail c;

        public b0(boolean r1, CardAdapter2 r2, CommentBean.CommentDetail r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r23) {
            if (this.a == false) goto L5;
            com.bytedance.ee.bear.middleground.comment.control.y r2 = CardAdapter2.access$getActionControl$p(this.b);
            CommentBean.CommentDetail r3 = this.c;
            CardAdapter2 r4 = this.b;
            r2.j(r3, r4, r4.getQuote(), 0, this.b.getParentType(), this.b.getParentToken(), this.b.getBizParams());
            return;
        L5:
            af5.b r1 = this.b.getConfig().Q;
            if (r1 == null) goto L10;
            com.bytedance.ee.bear.middleground.comment.performance.d r5 = r1.b();
            if (r5 == null) goto L10;
            r5.e(this.c.getComment_id(), "create");
        L10:
            String r6 = this.c.getContent();
            CommentBean.CommentDetail.ExtraEntity r7 = this.c.getExtra();
            if (r7 == null) goto L13;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r8 = r7.getImage_list();
        L14:
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r9 = r8;
            String r10 = this.b.getQuote();
            String r11 = this.c.getComment_id();
            String r12 = this.c.getReply_id();
            com.bytedance.ee.bear.rn.e r13 = new com.bytedance.ee.bear.rn.e(r10, r6, r11, false, false, r9, null, this.b.getParentType(), this.b.getParentToken(), r12, false, null, this.b.getPosition(), this.b.getBizParams(), null, null, this.c.getCommentType(), null, 183384);
            CardAdapter2.access$getActionControl$p(this.b).C(r13);
            return;
        L13:
            r8 = null;
            goto L14
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ QuoteViewHolder b;
        public final /* synthetic */ CommentBean.CommentDetail c;
        public final /* synthetic */ int d;

        public c(CardAdapter2 r1, QuoteViewHolder r2, CommentBean.CommentDetail r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            CardAdapter2 r3 = this.a;
            QuoteViewHolder r1 = this.b;
            CommentBean.CommentDetail r2 = this.c;
            int r4 = this.d;
            CommentBean r8 = r3.getCommentBean();
            if (r8 == null) goto L5;
            List<String> r9 = r8.getParticipantList();
        L6:
            r3.showCardMoreMenuList(r1, r2, r3, r4, r9);
            return;
        L5:
            r9 = null;
            goto L6
        }
    }

    public static final class c0 implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CardAdapter2 b;
        public final /* synthetic */ CommentBean.CommentDetail c;

        public c0(boolean r1, CardAdapter2 r2, CommentBean.CommentDetail r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r23) {
            if (this.a == false) goto L5;
            com.bytedance.ee.bear.middleground.comment.control.y r2 = CardAdapter2.access$getActionControl$p(this.b);
            CommentBean.CommentDetail r3 = this.c;
            CardAdapter2 r4 = this.b;
            r2.j(r3, r4, r4.getQuote(), 2, this.b.getParentType(), this.b.getParentToken(), this.b.getBizParams());
            return;
        L5:
            af5.b r1 = this.b.getConfig().Q;
            if (r1 == null) goto L10;
            com.bytedance.ee.bear.middleground.comment.performance.d r5 = r1.b();
            if (r5 == null) goto L10;
            r5.e(this.c.getReplyUUID(), "reply");
        L10:
            String r6 = this.c.getContent();
            CommentBean.CommentDetail.ExtraEntity r7 = this.c.getExtra();
            if (r7 == null) goto L13;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r8 = r7.getImage_list();
        L14:
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r9 = r8;
            com.bytedance.ee.bear.rn.e r10 = new com.bytedance.ee.bear.rn.e(null, r6, this.c.getComment_id(), false, false, r9, null, null, null, this.c.getReply_id(), false, null, this.b.getPosition(), this.b.getBizParams(), null, null, this.c.getCommentType(), null, 183769);
            CardAdapter2.access$getActionControl$p(this.b).z(r10);
            return;
        L13:
            r8 = null;
            goto L14
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ QuoteViewHolder b;
        public final /* synthetic */ CommentBean.CommentDetail c;
        public final /* synthetic */ int d;

        public d(CardAdapter2 r1, QuoteViewHolder r2, CommentBean.CommentDetail r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            CardAdapter2 r3 = this.a;
            QuoteViewHolder r1 = this.b;
            CommentBean.CommentDetail r2 = this.c;
            int r4 = this.d;
            CommentBean r8 = r3.getCommentBean();
            if (r8 == null) goto L5;
            List<String> r9 = r8.getParticipantList();
        L6:
            r3.showCardMoreMenuList(r1, r2, r3, r4, r9);
            return;
        L5:
            r9 = null;
            goto L6
        }
    }

    public static final class d0 implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ CommentBean.CommentDetail b;

        public d0(CardAdapter2 r1, CommentBean.CommentDetail r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CardAdapter2.access$getActionControl$p(this.a).n(this.b.getComment_id(), this.b.getCommentType(), this.b.getReply_id());
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ QuoteViewHolder b;
        public final /* synthetic */ CardAdapter2 c;
        public final /* synthetic */ CommentBean.CommentDetail d;

        public e(boolean r1, QuoteViewHolder r2, CardAdapter2 r3, CommentBean.CommentDetail r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            if (this.a == true) goto L6;
            Toast.showText(((RecyclerView.ViewHolder) this.b).itemView.getContext(), 2131889183);
            return;
        L6:
            CardAdapter2.access$getCommentListeners$p(this.c).o0().invoke();
            com.bytedance.ee.bear.middleground.comment.control.y r0 = CardAdapter2.access$getActionControl$p(this.c);
            String r1 = this.d.getComment_id();
            int r2 = this.d.getCommentType();
            boolean r3 = this.d.isWholeComment();
            boolean r4 = true;
            if (this.d.getCommentType() == 1) goto L10;
            r4 = false;
        L10:
            com.bytedance.ee.bear.middleground.comment.control.x.a(r0, r1, r2, r3, r4, false, null, 48);
        }
    }

    public static final class e0 implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CardAdapter2 b;
        public final /* synthetic */ CommentBean.CommentDetail c;

        public e0(boolean r1, CardAdapter2 r2, CommentBean.CommentDetail r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r15) {
            if (this.a == false) goto L5;
            com.bytedance.ee.bear.middleground.comment.control.y r0 = CardAdapter2.access$getActionControl$p(this.b);
            CommentBean.CommentDetail r1 = this.c;
            CardAdapter2 r2 = this.b;
            r0.j(r1, r2, r2.getQuote(), 1, this.b.getParentType(), this.b.getParentToken(), this.b.getBizParams());
            return;
        L5:
            af5.b r16 = this.b.getConfig().Q;
            if (r16 == null) goto L10;
            com.bytedance.ee.bear.middleground.comment.performance.d r17 = r16.b();
            if (r17 == null) goto L10;
            r17.e(this.c.getReplyUUID(), "edit");
        L10:
            String r3 = this.c.getComment_id();
            String r4 = this.c.getReply_id();
            String r5 = this.c.getContent();
            CommentBean.CommentDetail.ExtraEntity r6 = this.c.getExtra();
            if (r6 == null) goto L13;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r7 = r6.getImage_list();
        L14:
            com.bytedance.ee.bear.rn.d r18 = new com.bytedance.ee.bear.rn.d(r3, r4, r5, r7, false, false, this.b.getBizParams(), false, this.c.getCommentType(), false, 1456);
            CardAdapter2.access$getActionControl$p(this.b).p(r18);
            return;
        L13:
            r7 = null;
            goto L14
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2 a;

        public f(CardAdapter2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.a.getConfig().N.a(new ef5.a0(false));
        }
    }

    public static final class f0 implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ CommentBean.CommentDetail b;

        public f0(CardAdapter2 r1, CommentBean.CommentDetail r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r23) {
            af5.b r1 = this.a.getConfig().Q;
            if (r1 == null) goto L7;
            com.bytedance.ee.bear.middleground.comment.performance.d r2 = r1.b();
            if (r2 == null) goto L7;
            r2.e(this.b.getReplyUUID(), "revision");
        L7:
            String r5 = this.b.getComment_id();
            String r4 = this.b.getContent();
            Map<Object, Object> r16 = this.a.getBizParams();
            int r19 = this.b.getCommentType();
            com.bytedance.ee.bear.rn.e r3 = new com.bytedance.ee.bear.rn.e(null, r4, r5, false, false, null, null, null, null, this.b.getReply_id(), false, null, null, r16, null, null, r19, null, 187897);
            CardAdapter2.access$getActionControl$p(this.a).E(r3);
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ CommentBean.CommentDetail b;

        public g(CardAdapter2 r1, CommentBean.CommentDetail r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            CardAdapter2.access$getActionControl$p(this.a).f(this.b.getComment_id());
        }
    }

    public static final class g0 implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ CommentBean.CommentDetail b;

        public g0(CardAdapter2 r1, CommentBean.CommentDetail r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.ee.bear.middleground.comment.control.y r5 = CardAdapter2.access$getActionControl$p(this.a);
            CommentBean.CommentDetail r0 = this.b;
            r5.w(r0, r0.getReply_id(), null);
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ CommentBean.CommentDetail b;

        public h(CardAdapter2 r1, CommentBean.CommentDetail r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            CardAdapter2.access$getActionControl$p(this.a).d(this.b.getComment_id());
        }
    }

    public static final class h0 implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ ContentViewHolder b;
        public final /* synthetic */ CommentBean.CommentDetail c;

        public h0(CardAdapter2 r1, ContentViewHolder r2, CommentBean.CommentDetail r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.a.clickSmartAIReplyPreview(this.b, this.c);
        }
    }

    public static final class i implements com.bytedance.ee.bear.middleground.comment.cell.i.a {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ int b;

        @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
        public final void b(String r2) {
            Function0 r0 = CardAdapter2.access$getClickLink$p(this.a);
            if (r0 == null) goto L5;
            r0.invoke();
        L5:
            if (r2 == null) goto L8;
            CardAdapter2.access$getCommentListeners$p(this.a).b0().invoke(r2);
            return;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
        public final void c(String r3) {
            Intrinsics.checkNotNullParameter(r3, "uuid");
            tt5.a.h(CardAdapter2.TAG, "clickProfile");
            d(r3);
            CardAdapter2.access$getCommentListeners$p(this.a).s0().invoke(r3);
        }

        public final void d(String r4) {
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.comment.request_permission_if_no_cache") == false) goto L14;
            boolean r0 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
            SharePermissionViewModel r1 = this.a.getSharePermissionViewModel();
            if (r1 == null) goto L9;
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
            if (r1.f.containsKey(r4) == true) goto L9;
            boolean r5 = true;
        L10:
            if (r5 == false) goto L15;
            if (r0 == false) goto L16;
            this.a.notifyItemChanged(this.b);
            return;
        L16:
            return;
        L15:
            return;
        L9:
            r5 = false;
            goto L10
        }

        @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
        public final boolean isSameSpace(String r2) {
            return this.a.isSameSpaceInner(r2);
        }

        public i(CardAdapter2 r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.cell.i.a
        public final void a(String r3, String r4, MentionUserState r5) {
            Intrinsics.checkNotNullParameter(r3, "uuid");
            Intrinsics.checkNotNullParameter(r4, "content");
            Intrinsics.checkNotNullParameter(r5, "userState");
            tt5.a.h(CardAdapter2.TAG, "clickSharePermission");
            d(r3);
            com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
            if (r0.g("ccm.mention.optimizing_authorizaiton_v2") == true) goto L5;
        L11:
            CardAdapter2.access$getCommentListeners$p(this.a).e0().invoke(r3, r4);
            return;
        L5:
            if (r0.g("ccm.mention.optimizing_authorizaiton") == false) goto L11;
            boolean r1 = CardAdapter2.access$getActionControl$p(this.a).b(r3, StringsKt.removePrefix(r4, "@"));
            if (r1 == true) goto L9;
            r1 = ((Boolean) CardAdapter2.access$getCommentListeners$p(this.a).P0().invoke(r3, r4, r5)).booleanValue();
        L9:
            if (r1 == true) goto L13;
            CardAdapter2.access$getCommentListeners$p(this.a).e0().invoke(r3, r4);
            return;
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2 a;

        public j(CardAdapter2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.getOnClickEmpty();
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public static final class k implements View.OnLongClickListener {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r1) {
            return true;
        }
    }

    public static final class l implements View.OnClickListener {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class m implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ int b;

        public m(CardAdapter2 r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommentInputRequest r5 = new CommentInputRequest();
            r5.is_whole = true;
            r5.doc_token = this.a.getConfig().i;
            int r1 = 0;
            r5.type = 0;
            r5.show_voice = true;
            r5.show_comment_image = true;
            r5.show_insert_image = true;
            CommentBean r2 = this.a.getCommentBean();
            if (r2 == null) goto L5;
            r1 = r2.getCommentType();
        L5:
            r5.setCommentType(r1);
            com.bytedance.ee.bear.middleground.comment.control.z r3 = CardAdapter2.access$getCommentListeners$p(this.a);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.Comment");
            ((Comment) r3).S(r5);
            ((CommentBean.CommentDetail) ListProtector.get(this.a.commentDetails, this.b)).setInReply(true);
            ((Comment) CardAdapter2.access$getCommentListeners$p(this.a)).D = this.a.getItemCount() - 2;
            CardAdapter2 r6 = this.a;
            r6.notifyItemChanged(r6.getItemCount() - 1);
        }
    }

    public static final class n implements CommentImageAdapter.c {
        public final /* synthetic */ ContentViewHolder a;
        public final /* synthetic */ CommentBean.CommentDetail b;
        public final /* synthetic */ CardAdapter2 c;

        public n(ContentViewHolder r1, CommentBean.CommentDetail r2, CardAdapter2 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter.c
        public final void a(CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r5) {
            StringBuilder r0 = new StringBuilder("OnImageLoadStatusChange()... isHolderMatchesItem = ");
            CommentBean.CommentDetail r1 = this.a.u;
            String r2 = null;
            if (r1 == null) goto L5;
            String r3 = r1.getReply_id();
        L6:
            r0.append(Intrinsics.areEqual(r3, this.b.getReply_id()));
            r0.append(", holder reply_id = ");
            CommentBean.CommentDetail r4 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(this.c.commentDetails, this.a.getLayoutPosition());
            if (r4 == null) goto L9;
            String r6 = r4.getReply_id();
        L10:
            r0.append(r6);
            r0.append(", item content = ");
            r0.append(this.b.getReply_id());
            r0.append(", holder images = ");
            CommentBean.CommentDetail r7 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(this.c.commentDetails, this.a.getLayoutPosition());
            if (r7 == null) goto L15;
            CommentBean.CommentDetail.ExtraEntity r8 = r7.getExtra();
            if (r8 == null) goto L15;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r9 = r8.getImage_list();
        L16:
            r0.append(r9);
            r0.append(", item images = ");
            CommentBean.CommentDetail.ExtraEntity r10 = this.b.getExtra();
            if (r10 == null) goto L19;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r11 = r10.getImage_list();
        L20:
            r0.append(r11);
            tt5.a.h(CardAdapter2.TAG, r0.toString());
            CommentBean.CommentDetail r12 = this.a.u;
            if (r12 == null) goto L23;
            String r13 = r12.getReply_id();
        L25:
            if (Intrinsics.areEqual(r13, this.b.getReply_id()) == false) goto L63;
            CommentBean.CommentDetail r14 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(this.c.commentDetails, this.a.getLayoutPosition());
            if (r14 == this.b) goto L49;
            if (r14 == null) goto L31;
            r2 = r14.getReply_id();
        L31:
            if (Intrinsics.areEqual(r2, this.b.getReply_id()) == false) goto L49;
            if (r14 == null) goto L50;
            CommentBean.CommentDetail.ExtraEntity r15 = r14.getExtra();
            if (r15 == null) goto L50;
            List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r16 = r15.getImage_list();
            if (r16 == null) goto L50;
            Iterator<T> r17 = r16.iterator();
        L39:
            if (r17.hasNext() == false) goto L50;
            CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r18 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r17.next();
            if (Intrinsics.areEqual(r18.getToken(), r5.getToken()) == false) goto L39;
            if (Intrinsics.areEqual(r18.getSrc(), r5.getSrc()) == false) goto L39;
            if (Intrinsics.areEqual(r18.getOriginalSrc(), r5.getOriginalSrc()) == false) goto L39;
            if (Intrinsics.areEqual(r18.getUuid(), r5.getUuid()) == false) goto L39;
            r18.setLoadFail(r5.getLoadFail());
        L50:
            CardAdapter2.access$setRetryView(this.c, this.a, this.b);
            return;
        L49:
            tt5.a.k(CardAdapter2.TAG, "show data is not matched with source data! show data = " + this.b + ", source data = " + r14);
            goto L50
        L63:
            return;
        L23:
            r13 = null;
            goto L25
        L19:
            r11 = null;
        L15:
            r9 = null;
            goto L16
        L9:
            r6 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class o implements Runnable {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ ContentViewHolder b;

        public o(CardAdapter2 r1, ContentViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CardAdapter2.access$adjustTouchArea(this.a, this.b.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class p implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ ContentViewHolder a;
        public final /* synthetic */ ViewGroup.MarginLayoutParams b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.a.f.getLayout() != null) goto L6;
            this.a.f.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        L6:
            Layout r0 = this.a.f.getLayout();
            this.b.topMargin = (this.a.f.getTop() + ((r0.getLineTop(r0.getLineCount() - 1) + r0.getLineBottom(r0.getLineCount() - 1)) / 2)) - (this.a.o.getHeight() / 2);
            ViewGroup.MarginLayoutParams r2 = this.b;
            int r3 = this.a.f.getLeft();
            if ((this.a.f.getWidth() - r0.getLineWidth(r0.getLineCount() - 1)) >= this.a.o.getWidth()) goto L9;
            this.a.i.setVisibility(0);
            int r1 = this.a.f.getWidth() - this.a.o.getWidth();
        L10:
            r2.leftMargin = r3 + r1;
            this.a.o.setLayoutParams(this.b);
            this.a.f.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        L9:
            r1 = (int) r0.getLineWidth(r0.getLineCount() - 1);
            goto L10
        }

        public p(ContentViewHolder r1, ViewGroup.MarginLayoutParams r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class q implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ ViewGroup.MarginLayoutParams a;
        public final /* synthetic */ ContentViewHolder b;
        public final /* synthetic */ CardAdapter2 c;
        public final /* synthetic */ int d;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            ViewGroup.MarginLayoutParams r0 = this.a;
            int r1 = this.b.q.getLeft();
            int r2 = this.c.getImageSize() + this.c.getImageItemMargin();
            ContentViewHolder r3 = this.b;
            if (r3.s != 2) goto L5;
            int r4 = 2;
        L6:
            r0.leftMargin = r1 + (r2 * r4);
            ViewGroup.MarginLayoutParams r5 = this.a;
            int r6 = r3.q.getBottom();
            ContentViewHolder r7 = this.b;
            if (r7.s != 2) goto L9;
        L12:
            int r8 = (-r7.o.getHeight()) - this.c.getImageItemMargin();
        L13:
            r5.topMargin = r6 + r8;
            this.b.o.setLayoutParams(this.a);
            this.b.q.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        L9:
            if ((this.d % 3) != 0) goto L12;
            r8 = 0;
            goto L13
        L5:
            r4 = this.d % 3;
            goto L6
        }

        public q(ViewGroup.MarginLayoutParams r1, ContentViewHolder r2, CardAdapter2 r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class r implements View.OnClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ ContentViewHolder b;

        public r(CardAdapter2 r1, ContentViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            CardAdapter2 r0 = this.a;
            Intrinsics.checkNotNull(r3);
            CardAdapter2.access$setReactionTouchT(r0, r3);
            CardAdapter2.access$showReaction(this.a, this.b, 5);
        }
    }

    public static final class s implements View.OnLongClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ ContentViewHolder b;

        public s(CardAdapter2 r1, ContentViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r5) {
            CardAdapter2 r0 = this.a;
            Intrinsics.checkNotNull(r5);
            CardAdapter2.access$setReactionTouchT(r0, r5);
            CardAdapter2.showReaction$default(this.a, this.b, 0, 2, null);
            return true;
        }
    }

    public static final class t implements View.OnLongClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ ContentViewHolder b;

        public t(CardAdapter2 r1, ContentViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r5) {
            CardAdapter2 r0 = this.a;
            Intrinsics.checkNotNull(r5);
            CardAdapter2.access$setReactionTouchT(r0, r5);
            CardAdapter2.showReaction$default(this.a, this.b, 0, 2, null);
            return true;
        }
    }

    public static final class u implements View.OnLongClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ ContentViewHolder b;

        public u(CardAdapter2 r1, ContentViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r5) {
            CardAdapter2.showReaction$default(this.a, this.b, 0, 2, null);
            return true;
        }
    }

    public static final class v implements View.OnClickListener {
        public final /* synthetic */ ContentViewHolder a;

        public v(ContentViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ((RecyclerView.ViewHolder) this.a).itemView.performClick();
        }
    }

    public static final class w implements CommentImageAdapter.d {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ ContentViewHolder b;

        public w(CardAdapter2 r1, ContentViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.middleground.comment.image.CommentImageAdapter.d
        public final void a() {
            CardAdapter2.showReaction$default(this.a, this.b, 0, 2, null);
        }
    }

    public static final class x implements View.OnLongClickListener {
        public final /* synthetic */ CardAdapter2 a;
        public final /* synthetic */ ContentViewHolder b;

        public x(CardAdapter2 r1, ContentViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r5) {
            CardAdapter2 r0 = this.a;
            Intrinsics.checkNotNull(r5);
            CardAdapter2.access$setReactionTouchT(r0, r5);
            CardAdapter2.showReaction$default(this.a, this.b, 0, 2, null);
            return true;
        }
    }

    public static final class y implements View.OnLongClickListener {
        public static final y a = null;

        static {
            a = new y();
        }

        public y() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r1) {
            return true;
        }
    }

    public static final class z implements View.OnClickListener {
        public static final z a = null;

        static {
            a = new z();
        }

        public z() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    static {
        Companion = new a();
        COMMENT_IMAGE_OUTER_SPACE_WIDTH = com.bytedance.ee.util.ui.n.d(89);
        COMMENT_MAX_IMAGE_SIZE = com.bytedance.ee.util.ui.n.d(120);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public CommentBean getData() {
        CommentBean r0 = this.commentBean;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new CommentBean();
    }

    public int getItemCount() {
        return this.commentDetails.size();
    }

    public final boolean isInEdit() {
        List<CommentBean.CommentDetail> r0 = this.commentDetails;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (((CommentBean.CommentDetail) r1.next()).isEditStatus() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public void updateImageSize() {
        if (ForsetiHelper.d() == false) goto L6;
        int r0 = RangesKt.coerceAtMost(this.minWidthInWideScreen, this.config.c.getWidth());
        int r1 = COMMENT_IMAGE_OUTER_SPACE_WIDTH;
    L9:
        this.imageSize = ((r0 - r1) - (this.imageItemMargin * 2)) / 3;
        com.bytedance.ee.bear.middleground.comment.uitls.p r2 = this.config;
        if (r2.C == true) goto L12;
        return;
    L12:
        if (r2.getActivity().getResources().getConfiguration().orientation != 2) goto L16;
        this.imageSize = Math.min(this.imageSize, COMMENT_MAX_IMAGE_SIZE);
        return;
    L16:
        return;
    L6:
        if (ForsetiHelper.p() == false) goto L8;
        r0 = this.config.c.getWidth();
        r1 = COMMENT_IMAGE_OUTER_SPACE_WIDTH;
        goto L9
    L8:
        WindowManager r3 = (WindowManager) this.config.getActivity().getSystemService("window");
        DisplayMetrics r4 = new DisplayMetrics();
        r3.getDefaultDisplay().getMetrics(r4);
        r0 = r4.widthPixels;
        r1 = COMMENT_IMAGE_OUTER_SPACE_WIDTH;
        goto L9
    }

    public static final /* synthetic */ int access$getCOMMENT_IMAGE_OUTER_SPACE_WIDTH$cp() {
        return COMMENT_IMAGE_OUTER_SPACE_WIDTH;
    }

    public static final /* synthetic */ int access$getCOMMENT_MAX_IMAGE_SIZE$cp() {
        return COMMENT_MAX_IMAGE_SIZE;
    }

    public final boolean getAdminCanPreview() {
        return this.adminCanPreview;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public Map<Object, Object> getBizParam() {
        return this.bizParams;
    }

    public final Map<Object, Object> getBizParams() {
        return this.bizParams;
    }

    public final com.bytedance.ee.bear.middleground.comment.card.d getCardDataViewModel() {
        return this.cardDataViewModel;
    }

    public final int getCardPos() {
        return this.cardPos;
    }

    public final CommentBean getCommentBean() {
        return this.commentBean;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public List<CommentBean.CommentDetail> getCommentDetails() {
        return this.commentDetails;
    }

    public final com.bytedance.ee.bear.middleground.comment.uitls.p getConfig() {
        return this.config;
    }

    public final int getHeightFromTop() {
        return this.heightFromTop;
    }

    public final int getImageItemMargin() {
        return this.imageItemMargin;
    }

    public final int getImageSize() {
        return this.imageSize;
    }

    public final Function0<Unit> getOnClickEmpty() {
        return this.onClickEmpty;
    }

    public final Function6<String, Integer, String, CommentBean.CommentDetail.ExtraEntity.CommentImageEntity, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, CommentBean, Unit> getOnClickImageItem() {
        return this.onClickImageItem;
    }

    public final Function0<Unit> getOnResolve() {
        return this.onResolve;
    }

    public final String getParentToken() {
        return this.parentToken;
    }

    public final String getParentType() {
        return this.parentType;
    }

    public final String getPosition() {
        return this.position;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public String getPostion() {
        return this.position;
    }

    public final String getQuote() {
        return this.quote;
    }

    public final SharePermissionViewModel getSharePermissionViewModel() {
        return this.sharePermissionViewModel;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public com.bytedance.ee.bear.middleground.comment.export.w getUiState() {
        return this.uiState;
    }

    public static View INVOKEVIRTUAL_com_bytedance_ee_bear_middleground_comment_adapter_CardAdapter2_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.y access$getActionControl$p(CardAdapter2 r0) {
        return r0.actionControl;
    }

    public static final /* synthetic */ Function0 access$getClickLink$p(CardAdapter2 r0) {
        return r0.clickLink;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.middleground.comment.control.z access$getCommentListeners$p(CardAdapter2 r0) {
        return r0.commentListeners;
    }

    private final void adjustTouchArea(View r8) {
        if (r8.getVisibility() == 0) goto L6;
        Object r9 = r8.getParent();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.view.View");
        ((View) r9).setTouchDelegate(null);
        return;
    L6:
        Rect r0 = new Rect();
        r8.getHitRect(r0);
        Object r2 = r8.getParent();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.View");
        ((View) r2).setTouchDelegate(new TouchDelegate(new Rect(r0.left - 200, r0.top - 30, r0.right + 200, r0.bottom + 200), r8));
    }

    private final void checkFilePreviewPermission(final ContentViewHolder r4) {
        SharePermissionViewModel r0 = this.sharePermissionViewModel;
        if (r0 == null) goto L5;
        SharePermissionViewModel.PreviewPermissionState r1 = r0.h();
    L7:
        if (r1 != SharePermissionViewModel.PreviewPermissionState.STATE_INIT) goto L14;
        SharePermissionViewModel r2 = this.sharePermissionViewModel;
        if (r2 == null) goto L19;
        MutableLiveData<SharePermissionViewModel.PreviewPermissionState> r3 = r2.g;
        if (r3 == null) goto L20;
        r3.observe(this.config.getActivity(), new C03501(this, r4));
        return;
    L20:
        return;
    L19:
        return;
    L14:
        if (r1 != SharePermissionViewModel.PreviewPermissionState.STATE_TRUE) goto L16;
        boolean r5 = true;
    L17:
        handleFilePreviewPermission(r4, r5, false);
        tt5.a.h(TAG, "not need requestFilePreviewPermission reset:");
        return;
    L16:
        r5 = false;
        goto L17
    L5:
        r1 = null;
        goto L7
    }

    private final CommentBean.CommentDetail getCommentDetailByHolder(ContentViewHolder r2) {
        return (CommentBean.CommentDetail) CollectionsKt.getOrNull(this.commentDetails, r2.getAdapterPosition());
    }

    private final boolean hasSomeImageLoadFail(CommentBean.CommentDetail r3) {
        CommentBean.CommentDetail.ExtraEntity r0 = r3.getExtra();
        if (r0 == null) goto L7;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r1 = r0.getImage_list();
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L8:
        if (r2 != 0) goto L10;
        return false;
    L10:
        CommentBean.CommentDetail.ExtraEntity r4 = r3.getExtra();
        Intrinsics.checkNotNull(r4);
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r5 = r4.getImage_list();
        Intrinsics.checkNotNull(r5);
        Iterator<T> r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L17;
        if (((CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r6.next()).getLoadFail() == false) goto L12;
        return true;
    L17:
        return false;
    L7:
        r2 = 0;
        goto L8
    }

    private final void setReactionTouchT(View r3) {
        int[] r0 = new int[2];
        r3.getLocationOnScreen(r0);
        this.actionControl.m(r0[1]);
    }

    private final boolean shouldHideDeleteButton(CommentBean.CommentDetail r3) {
        if (r3.getError().isSuccess() == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(r3.getRetryType(), "delete") == true) goto L12;
        if (Intrinsics.areEqual(r3.getRetryType(), "update") == true) goto L12;
        if (r3.getReplyType() == 2) goto L12;
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public String findReplyIdByPosition(int r2) {
        if (r2 >= this.commentDetails.size()) goto L5;
        String r3 = ((CommentBean.CommentDetail) ListProtector.get(this.commentDetails, r2)).getReply_id();
        Intrinsics.checkNotNull(r3);
        return r3;
    L5:
        return "";
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public String getCommentId(CommentBean.CommentDetail r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        String r3 = r2.getComment_id();
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public int getCommentVisibility(CommentBean.CommentDetail r1) {
        CommentBean r2 = this.commentBean;
        if (r2 == null) goto L7;
        CommentBean.Extra r3 = r2.getExtra();
        if (r3 == null) goto L7;
        return r3.getVisibility();
    L7:
        return 0;
    }

    public int getItemViewType(int r3) {
        int r0 = CardAdapterHelper.a;
        List<CommentBean.CommentDetail> r1 = this.commentDetails;
        Intrinsics.checkNotNullParameter(r1, "dates");
        if (((CommentBean.CommentDetail) ListProtector.get(r1, r3)).isWholeComment() == false) goto L13;
        int r2 = r1.size();
        if (r3 != 0) goto L10;
        if (r2 != 1) goto L25;
        return CardAdapterHelper.ItemType.WHOLE_INPUT.getType();
    L25:
        return CardAdapterHelper.ItemType.WHOLE_TEXT.getType();
    L10:
        if (r3 != (r2 - 1)) goto L27;
        return CardAdapterHelper.ItemType.WHOLE_INPUT.getType();
    L27:
        return CardAdapterHelper.ItemType.WHOLE_CONTENT.getType();
    L13:
        r1.size();
        switch(((CommentBean.CommentDetail) ListProtector.get(r1, r3)).getReplyType()) {
            case -3: goto L23;
            case -2: goto L34;
            case -1: goto L33;
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            default: goto L28;
        };
    L28:
        return CardAdapterHelper.ItemType.UNKNOWN.getType();
    L29:
        return CardAdapterHelper.ItemType.ASIDE_NEW_INPUT.getType();
    L30:
        return CardAdapterHelper.ItemType.REVISION_CONTENT.getType();
    L31:
        return CardAdapterHelper.ItemType.REACTION.getType();
    L32:
        return CardAdapterHelper.ItemType.PART_CONTENT.getType();
    L33:
        return CardAdapterHelper.ItemType.QUOTE.getType();
    L34:
        return CardAdapterHelper.ItemType.PLACEHOLDER.getType();
    L23:
        return CardAdapterHelper.ItemType.PLACEHOLDER.getType();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public List<CommentBean.CommentDetail> getLast3Item(String r2) {
        Intrinsics.checkNotNullParameter(r2, "replyId");
        return new ArrayList();
    }

    public final db5.k[] getRevisionTextStylesOrNull(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L13;
        return null;
    L13:
        return new db5.k[]{new db5.k(0, r4.length(), 1)};
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public boolean isSameSpaceInner(String r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (((Boolean) this.commentListeners.v0().invoke(r2)).booleanValue() == false) goto L6;
        return true;
    }

    public void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.mRecyclerView = r2;
    }

    public final void setAdminCanPreview(boolean r1) {
        this.adminCanPreview = r1;
    }

    public final void setBizParams(Map<Object, ? extends Object> r1) {
        this.bizParams = r1;
    }

    public final void setCardPos(int r1) {
        this.cardPos = r1;
    }

    public final void setCommentBean(CommentBean r1) {
        this.commentBean = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public void setData(CommentBean r3) {
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
        this.commentBean = r3;
        com.bytedance.ee.bear.middleground.comment.export.w r0 = this.uiState;
        r0.c = this.config.q.f();
        com.bytedance.ee.bear.middleground.comment.export.w r1 = this.uiState;
        r1.d = this.config.q.getComment();
        com.bytedance.ee.bear.middleground.comment.export.w r2 = this.uiState;
        if (this.config.q.a() == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        r2.e = r4;
        if (r3.getComment_list() != null) goto L11;
        List<CommentBean.CommentDetail> r5 = new ArrayList();
    L12:
        this.commentDetails = r5;
        return;
    L11:
        List<CommentBean.CommentDetail> r6 = r3.getComment_list();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.collections.MutableList<com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean.CommentDetail>");
        r5 = TypeIntrinsics.asMutableList(r6);
        goto L12
    L5:
        if (this.config.u == true) goto L7;
        r4 = true;
        goto L8
    }

    public final void setHeightFromTop(int r1) {
        this.heightFromTop = r1;
    }

    public final void setImageItemMargin(int r1) {
        this.imageItemMargin = r1;
    }

    public final void setImageSize(int r1) {
        this.imageSize = r1;
    }

    public final void setOnClickEmpty(Function0<Unit> r1) {
        this.onClickEmpty = r1;
    }

    public final void setOnClickImageItem(Function6<? super String, ? super Integer, ? super String, ? super CommentBean.CommentDetail.ExtraEntity.CommentImageEntity, ? super List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, ? super CommentBean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.onClickImageItem = r2;
    }

    public final void setOnResolve(Function0<Unit> r1) {
        this.onResolve = r1;
    }

    public final void setParentToken(String r1) {
        this.parentToken = r1;
    }

    public final void setParentType(String r1) {
        this.parentType = r1;
    }

    public final void setPosition(String r1) {
        this.position = r1;
    }

    public final void setQuote(String r1) {
        this.quote = r1;
    }

    public static final /* synthetic */ void access$adjustTouchArea(CardAdapter2 r0, View r1) {
        r0.adjustTouchArea(r1);
    }

    public static final /* synthetic */ void access$setReactionTouchT(CardAdapter2 r0, View r1) {
        r0.setReactionTouchT(r1);
    }

    private final void adjustPosition(TextView r4, View r5) {
        this.config.N.a(new ef5.c(this.mRecyclerView, r4, r5));
    }

    private final void bindContentViewHolder(ContentViewHolder r4, int r5) {
        CommentBean.CommentDetail r0 = (CommentBean.CommentDetail) ListProtector.get(this.commentDetails, r5);
        if (r0.getReply_id() != null) goto L5;
        return;
    L5:
        r4.u = r0;
        setBackGround(r4, r0);
        setAvatar(r4, r0);
        setProfile(r4, r0);
        setTranslateIcon(r4, r0);
        setContent(r4, r0, r5);
        setSmartAIReplyPreview(r4, r0);
        r4.d.setText(r0.getName());
        setTime(r0, r4);
        setReaction(r4, r0);
        setTranslateContent(r4, r0, r5);
        setMore(r4, r0);
        setCommentImageList(r4, r0);
        setAnim(r4, r0);
        setContentLoadingOrFailStatus(r4, r0);
        setRetryView(r4, r0);
    }

    private final void bindQuoteText(QuoteViewHolder r5, CommentBean.CommentDetail r6) {
        CommentBean r0 = this.commentBean;
        int r1 = 0;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        r5.d.setText(this.config.getActivity().getText(2131889294));
    L12:
        if (this.config.e0 == false) goto L25;
        CommentBean r3 = this.commentBean;
        if (r3 == null) goto L18;
        CommentBean.Extra r4 = r3.getExtra();
        if (r4 == null) goto L18;
        Integer r7 = Integer.valueOf(r4.getVisibility());
    L19:
        if (r7 == null) goto L25;
        r5.a.setVisibility(8);
        ImageView r8 = r5.b;
        if (getCommentVisibility(r6) != 0) goto L24;
        r1 = 8;
    L24:
        r8.setVisibility(r1);
        r5.b.setOnClickListener(new f(this));
        return;
    L18:
        r7 = null;
    L25:
        r5.a.setVisibility(8);
        return;
    L10:
        r5.d.setText(r6.getContent());
        goto L12
    L5:
        if (r0.getCommentType() != 2) goto L7;
        r2 = true;
        goto L8
    }

    private final void bindRevisionIcon(QuoteViewHolder r5, CommentBean.CommentDetail r6) {
        if (r6.getReply_id() != null) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (r6.getError().code == 0) goto L8;
        boolean r0 = true;
    L10:
        if (this.config.q.f() == false) goto L20;
        if (r0 == true) goto L20;
        CommentBean r2 = this.commentBean;
        if (r2 != null) goto L15;
    L17:
        r1 = false;
    L18:
        if (r1 == true) goto L20;
        r5.j.setVisibility(0);
        r5.i.setOnClickListener(new g(this, r6));
        r5.h.setOnClickListener(new h(this, r6));
        return;
    L15:
        if (r2.isCanPerformAction() == true) goto L17;
    L20:
        r5.j.setVisibility(8);
        return;
    L8:
        r0 = false;
        goto L10
    }

    private final void bindRevisionViewHolder(RevisionViewHolder r2, int r3) {
        if (((CommentBean.CommentDetail) ListProtector.get(this.commentDetails, r3)).getReply_id() != null) goto L5;
        return;
    L5:
        bindContentViewHolder(r2, r3);
    }

    private final boolean isHolderMatchesItem(ContentViewHolder r2, CommentBean.CommentDetail r3) {
        CommentBean.CommentDetail r4 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(this.commentDetails, r2.getLayoutPosition());
        if (r4 == null) goto L5;
        String r5 = r4.getReply_id();
    L7:
        return Intrinsics.areEqual(r5, r3.getReply_id());
    L5:
        r5 = null;
        goto L7
    }

    private final void setAnim(ContentViewHolder r5, CommentBean.CommentDetail r6) {
        if (TextUtils.isEmpty(this.cardDataViewModel.i) == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.cardDataViewModel.i, r6.getReply_id()) == true) goto L7;
        return;
    L7:
        if (this.cardDataViewModel.j == true) goto L12;
        this.config.N.a(new ef5.b(CardAdapterActionType.SetAnim, this.mRecyclerView, r5, r6));
        return;
    }

    private final void setContentLoadingOrFailStatus(ContentViewHolder r5, CommentBean.CommentDetail r6) {
        if (r6.getError().isSuccess() == true) goto L5;
        r5.j.setVisibility(0);
    L6:
        r5.i.setVisibility(8);
        if (r6.isSending() == false) goto L18;
        ViewGroup.LayoutParams r0 = r5.o.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        CommentBean.CommentDetail.ExtraEntity r2 = r6.getExtra();
        if (r2 == null) goto L13;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r3 = r2.getImage_list();
        if (r3 == null) goto L13;
        int r4 = r3.size();
    L14:
        if (r4 != 0) goto L16;
        r5.f.getViewTreeObserver().addOnPreDrawListener(new p(r5, r1));
    L17:
        r5.o.setVisibility(0);
        r5.o.playAnimation();
        return;
    L16:
        int r7 = r6.getExtra().getImage_list().size();
        r5.q.getViewTreeObserver().addOnPreDrawListener(new q(r1, r5, this, r7));
    L13:
        r4 = 0;
        goto L14
    L18:
        r5.o.setVisibility(8);
        return;
    L5:
        r5.j.setVisibility(8);
        goto L6
    }

    private final void setProfile(ContentViewHolder r2, CommentBean.CommentDetail r3) {
        r2.c.setOnClickListener(new a0(r3, this));
    }

    private final void setRetryView(ContentViewHolder r3, CommentBean.CommentDetail r4) {
        r3.m.setVisibility(8);
        if (r4.getError().isSuccess() == true) goto L6;
        setRetryViewForSend(r3, r4);
        return;
    L6:
        if (hasSomeImageLoadFail(r4) == false) goto L8;
        setRetryViewForImageLoad(r3, r4);
        return;
    L8:
        r3.p.setVisibility(8);
        r3.p.setOnClickListener(null);
    }

    private final void setRetryViewForImageLoad(final ContentViewHolder r4, final CommentBean.CommentDetail r5) {
        r4.p.setVisibility(0);
        r4.l.setText(this.config.getActivity().getString(2131887327));
        r4.m.setVisibility(8);
        r4.k.setOnClickListener(new ViewOnClickListenerC03511(r4, this, r5));
    }

    private final void setRetryViewForSend(ContentViewHolder r9, CommentBean.CommentDetail r10) {
        int r1 = 0;
        r9.p.setVisibility(0);
        boolean r0 = ((com.bytedance.ee.bear.review.a) org.koin.java.a.c(com.bytedance.ee.bear.review.a.class, null, null, 6)).b(r10.getError().code);
        boolean r5 = true;
        if (r10.getReplyType() != 2) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L8;
    L11:
        View r4 = r9.k;
        if (r5 == false) goto L14;
        int r7 = 0;
    L15:
        r4.setVisibility(r7);
        String r6 = r10.getRetryType();
        if (r6 != null) goto L18;
    L36:
        r9.k.setOnClickListener(null);
    L37:
        if (r3 == false) goto L40;
        if (r5 == false) goto L40;
        r9.k.setOnClickListener(new f0(this, r10));
    L40:
        if (r3 == false) goto L45;
        if (r5 == false) goto L43;
        int r2 = 2131889275;
    L68:
        r9.l.setText(this.config.getActivity().getText(r2));
        View r8 = r9.m;
        if (shouldHideDeleteButton(r10) == false) goto L71;
        r1 = 8;
    L71:
        r8.setVisibility(r1);
        r9.m.setOnClickListener(new g0(this, r10));
        return;
    L43:
        r2 = 2131889276;
        goto L68
    L45:
        if (r10.getError().isNetFail() == false) goto L48;
        r2 = 2131887323;
        goto L68
    L48:
        if (r10.getError().isNoPermission() == false) goto L51;
        r2 = 2131887324;
        goto L68
    L51:
        if (r10.getError().isReviewFail() == false) goto L54;
        r2 = 2131887329;
        goto L68
    L54:
        if (r10.getError().isBanFail() == false) goto L57;
        r2 = 2131889734;
        goto L68
    L57:
        if (r10.getError().isMultiGeoFail() == false) goto L60;
        r2 = 2131887325;
        goto L68
    L60:
        if (r10.getError().isMultiGeoPrepare() == false) goto L63;
        r2 = 2131887326;
        goto L68
    L63:
        if (r10.getError().isCommentQuantityLimit() == false) goto L67;
        if (r3 == false) goto L66;
        r2 = 2131889468;
        goto L68
    L66:
        r2 = 2131888894;
        goto L68
    L67:
        r2 = 2131887328;
        goto L68
    L18:
        switch(r6.hashCode()) {
            case -1335458389: goto L33;
            case -838846263: goto L29;
            case 96417: goto L25;
            case 108401386: goto L21;
            default: goto L36;
        };
    L21:
        if (r6.equals("reply") == false) goto L36;
        r9.k.setOnClickListener(new c0(r0, this, r10));
        goto L37
    L25:
        if (r6.equals("add") == false) goto L36;
        r9.k.setOnClickListener(new b0(r0, this, r10));
        goto L37
    L29:
        if (r6.equals("update") == false) goto L36;
        r9.k.setOnClickListener(new e0(r0, this, r10));
        goto L37
    L33:
        if (r6.equals("delete") == false) goto L36;
        r9.k.setOnClickListener(new d0(this, r10));
        goto L37
    L14:
        r7 = 8;
        goto L15
    L8:
        if (this.actionControl.l(r10.getUser_id()) == true) goto L11;
        r5 = false;
        goto L11
    L5:
        r3 = false;
        goto L6
    }

    private final void showReaction(ContentViewHolder r7, int r8) {
        CommentBean.CommentDetail r2 = getCommentDetailByHolder(r7);
        if (r2 != null) goto L6;
        tt5.a.k(TAG, "showReaction, item is null");
        return;
    L6:
        this.actionControl.o(((RecyclerView.ViewHolder) r7).itemView, r2, this, r7.getAdapterPosition(), r8);
    }

    public void clickSmartAIReplyPreview(ContentViewHolder r7, CommentBean.CommentDetail r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        this.commentListeners.T().c.invoke();
        com.bytedance.ee.bear.middleground.comment.uitls.h r0 = this.config.d0;
        String r9 = r8.getSmartReplyData().getAiReplyId();
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        String r3 = r8.getSmartReplyData().getCommentId();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        String r4 = r8.getSmartReplyData().getReplyId();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        String r5 = r8.getSmartReplyData().getAiReplyUserType().getValue();
        r0.c("smart_reply_answer_full", r9, r3, r4, r5);
        this.actionControl.c(r8.getComment_id(), r8.getReply_id());
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        boolean r1 = true;
        int r2 = 0;
        if ((r9 instanceof PlaceHolderViewHolder) == false) goto L53;
        if (r10 == 0) goto L7;
        r1 = false;
    L7:
        int r11 = com.bytedance.ee.util.ui.n.t();
        RecyclerView r0 = this.mRecyclerView;
        if (r0 == null) goto L10;
        int r3 = r0.getMeasuredHeight();
    L11:
        RecyclerView r4 = this.mRecyclerView;
        if (r4 == null) goto L14;
        int r5 = r4.getHeight();
    L15:
        int r6 = this.config.c.getMeasuredHeight();
        int r7 = this.config.c.getHeight();
        Window r8 = this.config.getActivity().getWindow();
        if (r8 == null) goto L20;
        View r12 = INVOKEVIRTUAL_com_bytedance_ee_bear_middleground_comment_adapter_CardAdapter2_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r8);
        if (r12 == null) goto L20;
        int r13 = r12.getHeight();
    L21:
        if (r3 <= 0) goto L23;
        r11 = r3;
    L32:
        if (r1 == false) goto L50;
        int r14 = getItemCount();
        if (r14 != 3) goto L36;
        int r15 = r11 / 2;
    L40:
        this.heightFromTop = r15;
        if (this.config.s == false) goto L49;
        this.heightFromTop = r15 - ((int) (r11 * 0.2f));
        int r16 = y9c.d.a(150);
        RecyclerView r17 = this.mRecyclerView;
        if (r17 == null) goto L45;
        r2 = r17.getMeasuredHeight();
    L45:
        if (r2 <= r16) goto L49;
        RecyclerView r18 = this.mRecyclerView;
        Intrinsics.checkNotNull(r18);
        if ((r18.getMeasuredHeight() - this.heightFromTop) >= r16) goto L49;
        RecyclerView r19 = this.mRecyclerView;
        Intrinsics.checkNotNull(r19);
        this.heightFromTop = r19.getMeasuredHeight() - r16;
    L49:
        r9.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, this.heightFromTop));
    L51:
        r9.itemView.setOnClickListener(new j(this));
        r9.itemView.setOnLongClickListener(k.a);
        return;
    L36:
        if (r14 == 4) goto L38;
        r15 = r11 / 3;
        goto L40
    L38:
        r15 = (int) (r11 * 0.4f);
        goto L40
    L50:
        r9.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, r11 / 5));
        goto L51
    L23:
        if (r5 <= 0) goto L25;
        r11 = r5;
        goto L32
    L25:
        if (r6 <= 0) goto L27;
        r11 = r6;
        goto L32
    L27:
        if (r7 <= 0) goto L29;
        r11 = r7;
        goto L32
    L29:
        if (r13 <= 0) goto L32;
        r11 = r13;
    L20:
        r13 = 0;
        goto L21
    L14:
        r5 = 0;
        goto L15
    L10:
        r3 = 0;
        goto L11
    L53:
        if ((r9 instanceof QuoteViewHolder) == false) goto L56;
        CommentBean.CommentDetail r20 = (CommentBean.CommentDetail) ListProtector.get(this.commentDetails, r10);
        QuoteViewHolder r21 = (QuoteViewHolder) r9;
        bindQuoteText(r21, r20);
        bindQuoteMenu(r21, r20, r10);
        r9.itemView.setOnClickListener(l.a);
        return;
    L56:
        if ((r9 instanceof RevisionViewHolder) == false) goto L58;
        bindRevisionViewHolder((RevisionViewHolder) r9, r10);
        return;
    L58:
        CommentBean.CommentDetail r22 = null;
        if ((r9 instanceof ContentViewHolder) == false) goto L62;
        ContentViewHolder r23 = (ContentViewHolder) r9;
        RichTextInjector.b(r23.f, null, null, false, 24);
        RichTextInjector.b(r23.a, null, null, false, 24);
        bindContentViewHolder(r23, r10);
        return;
    L62:
        if ((r9 instanceof ReactionViewHolder) == false) goto L86;
        ReactionViewHolder r24 = (ReactionViewHolder) r9;
        CommentBean.CommentDetail r110 = (CommentBean.CommentDetail) ListProtector.get(this.commentDetails, r10);
        r24.getClass();
        Intrinsics.checkNotNullParameter(r110, "commentDetail");
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r24.f = r110;
        gf5.d r25 = r24.b.N;
        CardAdapterActionType r26 = CardAdapterActionType.SetContentReaction;
        RecyclerView r27 = r24.d;
        if (r110 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("commentDetail");
        r110 = null;
    L67:
        r25.a(new ef5.b(r26, r27, r24, r110));
        String r111 = r24.c.i;
        if (r111 == null) goto L76;
        CommentBean.CommentDetail r28 = r24.f;
        if (r28 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("commentDetail");
        r28 = null;
    L74:
        if (r111.equals(r28.getComment_id()) != true) goto L76;
    L77:
        if (r1 == true) goto L79;
        return;
    L79:
        if (r24.c.j == true) goto L100;
        gf5.d r112 = r24.b.N;
        CardAdapterActionType r29 = CardAdapterActionType.SetAnim;
        RecyclerView r30 = r24.d;
        CommentBean.CommentDetail r31 = r24.f;
        if (r31 == null) goto L83;
        r22 = r31;
    L84:
        r112.a(new ef5.b(r29, r30, r24, r22));
        return;
    L83:
        Intrinsics.throwUninitializedPropertyAccessException("commentDetail");
        goto L84
    L100:
        return;
    L76:
        r1 = false;
        goto L77
    L86:
        if ((r9 instanceof InputViewHolder) == false) goto L92;
        r9.itemView.setOnClickListener(new m(this, r10));
        View r32 = r9.itemView;
        if (((CommentBean.CommentDetail) ListProtector.get(this.commentDetails, r10)).isInReply() == false) goto L90;
        r2 = 8;
    L90:
        r32.setVisibility(r2);
        return;
    L92:
        if ((r9 instanceof UnknownViewHolder) == false) goto L103;
        ((UnknownViewHolder) r9).a.setImageResource(kac.a.b(2131254630));
        return;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        if (r12 != CardAdapterHelper.ItemType.PLACEHOLDER.getType()) goto L7;
        return new PlaceHolderViewHolder(new View(this.config.getActivity()));
    L7:
        if (r12 != CardAdapterHelper.ItemType.QUOTE.getType()) goto L11;
        return new QuoteViewHolder(this, LayoutInflater.from(this.config.getActivity()).inflate(2131559855, r11, false));
    L11:
        if (r12 != CardAdapterHelper.ItemType.PART_CONTENT.getType()) goto L15;
        return new ContentViewHolder(this, LayoutInflater.from(this.config.getActivity()).inflate(2131559851, r11, false));
    L15:
        if (r12 != CardAdapterHelper.ItemType.WHOLE_CONTENT.getType()) goto L19;
        return new ContentViewHolder(this, LayoutInflater.from(this.config.getActivity()).inflate(2131559852, r11, false));
    L19:
        if (r12 != CardAdapterHelper.ItemType.WHOLE_TEXT.getType()) goto L23;
        return new TextViewHolder(LayoutInflater.from(this.config.getActivity()).inflate(2131559874, r11, false));
    L23:
        if (r12 != CardAdapterHelper.ItemType.WHOLE_INPUT.getType()) goto L27;
        return new InputViewHolder(LayoutInflater.from(this.config.getActivity()).inflate(2131559873, r11, false));
    L27:
        if (r12 != CardAdapterHelper.ItemType.REACTION.getType()) goto L31;
        return new ReactionViewHolder(LayoutInflater.from(this.config.getActivity()).inflate(2131559856, r11, false), this.config, this.actionControl, this.commentListeners, this.cardDataViewModel, this.mRecyclerView);
    L31:
        if (r12 != CardAdapterHelper.ItemType.REVISION_CONTENT.getType()) goto L35;
        return new RevisionViewHolder(this, LayoutInflater.from(this.config.getActivity()).inflate(2131559851, r11, false));
    L35:
        if (r12 != CardAdapterHelper.ItemType.UNKNOWN.getType()) goto L39;
        return new UnknownViewHolder(LayoutInflater.from(this.config.getActivity()).inflate(2131559857, r11, false));
    L39:
        throw new RuntimeException("type is  Invalid");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.export.ICardAdapter
    public void onItemVisible(int r7, int r8) {
        tt5.a.h(TAG, "onItemVisible, first: " + r7 + ", last: " + r8);
        if (this.commentDetails.isEmpty() == false) goto L6;
        return;
    L6:
        if (r7 < this.commentDetails.size()) goto L9;
        r7 = this.commentDetails.size() - 1;
    L9:
        if (r8 < this.commentDetails.size()) goto L11;
        r8 = this.commentDetails.size() - 1;
    L11:
        ArrayList r0 = new ArrayList();
        if (r7 > r8) goto L28;
    L13:
        CommentBean.CommentDetail r3 = (CommentBean.CommentDetail) ListProtector.get(this.commentDetails, r7);
        String[] r4 = r3.getMessageIds();
        if (r4 == null) goto L20;
        boolean r5 = false;
        if (r4.length != 0) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == true) goto L20;
    L21:
        if (r5 == false) goto L23;
    L25:
        if (r7 == r8) goto L28;
        r7 = r7 + 1;
        goto L13
    L23:
        if (r3.getReadStatus() != 1) goto L25;
        CollectionsKt.addAll(r0, r3.getMessageIds());
        r3.setReadStatus(2);
        goto L25
    L18:
        r6 = false;
    L20:
        r5 = true;
    L28:
        if ((!r0.isEmpty()) == false) goto L32;
        tt5.a.h(TAG, "readMessage: " + r0);
        this.actionControl.g(r0);
        return;
    }

    public final void setAvatar(ContentViewHolder r3, CommentBean.CommentDetail r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "item");
        Glide.with(((RecyclerView.ViewHolder) r3).itemView.getContext()).load(new BearGlideUrl(r4.getAvatar_url())).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(2131235295).into(r3.c);
    }

    public void setBackGround(ContentViewHolder r5, CommentBean.CommentDetail r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        int r1 = 2131235311;
        int r2 = 2131233327;
        int r3 = 2131233329;
        if (r6.isEditStatus() == true) goto L5;
        int r7 = 2131100557;
    L9:
        r5.n.setBackgroundResource(r1);
        View r0 = r5.n;
        r0.setBackgroundTintList(r0.getResources().getColorStateList(r7));
        SmartReplyPreview r8 = r5.r;
        TextView r4 = null;
        if (r8 == null) goto L12;
        View r9 = r8.findViewById(2131385747);
    L13:
        SmartReplyPreview r10 = r5.r;
        if (r10 == null) goto L16;
        r4 = (TextView) r10.findViewById(2131385748);
    L16:
        if (r9 == null) goto L18;
        r9.setBackgroundResource(r2);
    L18:
        if (r4 == null) goto L21;
        r4.setBackgroundResource(r3);
        return;
    L21:
        return;
    L12:
        r9 = null;
        goto L13
    L5:
        if (r6.isWholeComment() == false) goto L7;
        r1 = 2131235305;
        r7 = 2131108712;
        goto L9
    L7:
        r7 = 2131101127;
        r2 = 2131233328;
        r3 = 2131233330;
        goto L9
    }

    public void setCommentImageList(ContentViewHolder r6, CommentBean.CommentDetail r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        tt5.a.h(TAG, "setCommentImageList....");
        CommentBean.CommentDetail.ExtraEntity r0 = r7.getExtra();
        if (r0 == null) goto L5;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r1 = r0.getImage_list();
    L7:
        if (r1 == null) goto L9;
        int r3 = r1.size();
    L11:
        if (this.config.T == false) goto L16;
        if (r3 <= 0) goto L16;
        if (r1 == null) goto L16;
        checkFilePreviewPermission(r6);
    L16:
        if (this.config.F == false) goto L19;
        if (r3 <= 0) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == true) goto L23;
        r6.q.setVisibility(8);
        r6.q.setAdapter(null);
        r6.t.l = null;
        return;
    L23:
        r6.q.setVisibility(0);
        r6.q.setAdapter(r6.t);
        updateImageSize();
        GridLayoutManager r2 = r6.q.getLayoutManager();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        r6.X3(r3);
        r6.s = r2.getSpanCount();
        r6.W3(r3);
        CommentImageAdapter r5 = r6.t;
        r5.p.dispose();
        r5.z2(r1, false);
        r6.t.m = new n(r6, r7, this);
        return;
    L19:
        r4 = false;
        goto L20
    L9:
        r3 = 0;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    public void setMore(ContentViewHolder r7, CommentBean.CommentDetail r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        View r0 = r7.g;
        if (r8.isSending() == false) goto L5;
    L17:
        int r2 = 8;
    L18:
        r0.setVisibility(r2);
        r7.g.setOnClickListener(new r(this, r7));
        ((RecyclerView.ViewHolder) r7).itemView.setOnLongClickListener(new s(this, r7));
        r7.f.setOnLongClickListener(new t(this, r7));
        RecyclerView r1 = r7.q;
        u r3 = new u(this, r7);
        v r4 = new v(r7);
        if (r1 == null) goto L21;
        final GestureDetector r5 = new GestureDetector(r1.getContext(), new com.bytedance.ee.bear.middleground.comment.uitls.u(r4, r1, r3));
        r1.setOnTouchListener(new com.bytedance.ee.bear.middleground.comment.uitls.t(r5));
    L21:
        CommentImageAdapter r6 = r7.t;
        r6.l = new w(this, r7);
        r7.a.setOnLongClickListener(new x(this, r7));
        if (r8.isSending() == false) goto L27;
        ((RecyclerView.ViewHolder) r7).itemView.setOnLongClickListener(null);
        r7.f.setOnLongClickListener(null);
        r7.t.l = null;
        RecyclerView r9 = r7.q;
        y r10 = y.a;
        z r11 = z.a;
        if (r9 == null) goto L28;
        final GestureDetector r12 = new GestureDetector(r9.getContext(), new com.bytedance.ee.bear.middleground.comment.uitls.u(r11, r9, r10));
        r9.setOnTouchListener(new com.bytedance.ee.bear.middleground.comment.uitls.t(r12));
        return;
    L28:
        return;
    L27:
        return;
    L5:
        if (r8.getError().isSuccess() == false) goto L17;
        if (isInEdit() == true) goto L9;
    L10:
        CommentBean r13 = this.commentBean;
        r2 = 0;
        if (r13 != null) goto L13;
    L15:
        boolean r14 = false;
    L16:
        if (r14 == false) goto L18;
    L13:
        if (r13.isCanPerformAction() == true) goto L15;
        r14 = true;
        goto L16
    L9:
        if (r8.isWholeComment() == false) goto L17;
        goto L10
    }

    public void setReaction(ContentViewHolder r5, CommentBean.CommentDetail r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "commentDetail");
        this.config.N.a(new ef5.b(CardAdapterActionType.SetReaction, this.mRecyclerView, r5, r6));
    }

    public void setSmartAIReplyPreview(ContentViewHolder r11, final CommentBean.CommentDetail r12) {
        Intrinsics.checkNotNullParameter(r11, "holder");
        Intrinsics.checkNotNullParameter(r12, "item");
        if (this.config.q.b() == true) goto L5;
    L28:
        SmartReplyPreview r13 = r11.r;
        if (r13 == null) goto L33;
        r13.setVisibility(8);
        return;
    L33:
        return;
    L5:
        if (r12.getSmartReplyData() == null) goto L28;
        SmartReplyData r0 = r12.getSmartReplyData();
        if (r0 == null) goto L9;
        String r1 = r0.getPlainTextPreview();
    L11:
        if (r1 != null) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == true) goto L28;
        final SmartReplyPreview r3 = r11.r;
        if (r3 == null) goto L32;
        r3.setVisibility(0);
        String r4 = r12.getSmartReplyData().getPlainTextPreview();
        if (r3.getPreviewContentTv() == null) goto L26;
        int r5 = RichTextInjector.a;
        RichTextInjector.c(r3.getPreviewContentTv(), this.userIds, null, null, 2131106607, false, 32);
        CommentTextView r6 = r3.getPreviewContentTv();
        if (r6 == null) goto L26;
        r6.setRawString(r4);
    L26:
        r3.setOnClickListener(new h0(this, r11, r12));
        r3.setOnLongClickListener(new CardAdapter2$setSmartAIReplyPreview$1$2(this, r12, r3));
        return;
    L32:
        return;
    L13:
        if (r1.length() == 0) goto L16;
        r2 = false;
        goto L17
    L9:
        r1 = null;
        goto L11
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setTime(CommentBean.CommentDetail r4, ContentViewHolder r5) {
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r5, "holder");
        CommentBean r0 = getData();
        AppCompatTextView r1 = r5.e;
        if (r0.isActionBlocked(CommentAction.TIMESTAMP) == false) goto L5;
        int r2 = 8;
    L6:
        r1.setVisibility(r2);
        r5.e.setTime(r4);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void setTranslateIcon(ContentViewHolder r5, CommentBean.CommentDetail r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        this.config.N.a(new ef5.b(CardAdapterActionType.SetTranslateIcon, this.mRecyclerView, r5, r6));
    }

    public static final /* synthetic */ void access$setRetryView(CardAdapter2 r0, ContentViewHolder r1, CommentBean.CommentDetail r2) {
        r0.setRetryView(r1, r2);
    }

    public static final /* synthetic */ void access$showReaction(CardAdapter2 r0, ContentViewHolder r1, int r2) {
        r0.showReaction(r1, r2);
    }

    private final un5.a.InterfaceC0318a createContentLinkClickListener(String r3, int r4, int r5) {
        return this.actionControl.H(r3, r4, new i(this, r5));
    }

    private final void handleFilePreviewPermission(ContentViewHolder r1, boolean r2, boolean r3) {
        CommentImageAdapter r4 = r1.t;
        r4.e = r3;
        r4.d = r2;
        r4.notifyDataSetChanged();
    }

    public void bindQuoteMenu(QuoteViewHolder r7, CommentBean.CommentDetail r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        this.actionControl.q();
        this.actionControl.h();
        boolean r1 = true;
        if (r8.getError().code == 0) goto L5;
        boolean r0 = true;
    L6:
        CommentBean r3 = this.commentBean;
        if (r3 != null) goto L9;
    L11:
        boolean r4 = false;
    L13:
        if (r4 == true) goto L78;
        if (r0 == true) goto L78;
        CommentBean r2 = this.commentBean;
        if (r2 != null) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L41;
        String r6 = this.config.O;
        if (r6 != null) goto L26;
    L29:
        boolean r10 = true;
    L30:
        if (r10 == true) goto L39;
        CommentBean r11 = this.commentBean;
        if (r11 != null) goto L34;
    L36:
        r1 = false;
    L37:
        if (r1 == true) goto L39;
        r7.g.setVisibility(0);
        r7.f.setVisibility(0);
        r7.e.setVisibility(8);
        r7.f.setOnClickListener(new c(this, r7, r8, r9));
    L40:
        bindRevisionIcon(r7, r8);
        return;
    L34:
        if (r11.isActionBlocked(CommentAction.QUOTE_MORE) != true) goto L36;
    L39:
        r7.g.setVisibility(8);
        r7.f.setVisibility(8);
        r7.e.setVisibility(8);
        goto L40
    L26:
        if (r6.length() == 0) goto L29;
        r10 = false;
        goto L30
    L41:
        String r12 = this.config.O;
        if (r12 != null) goto L44;
    L47:
        boolean r13 = true;
    L48:
        if (r13 == true) goto L57;
        CommentBean r14 = this.commentBean;
        if (r14 != null) goto L52;
    L54:
        boolean r15 = false;
    L55:
        if (r15 == true) goto L57;
        r7.g.setVisibility(0);
        r7.f.setVisibility(0);
        r7.e.setVisibility(8);
        r7.j.setVisibility(8);
        r7.f.setOnClickListener(new d(this, r7, r8, r9));
        return;
    L52:
        if (r14.isActionBlocked(CommentAction.QUOTE_MORE) != true) goto L54;
        r15 = true;
    L57:
        r7.f.setVisibility(8);
        r7.j.setVisibility(8);
        boolean r16 = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.comment.reslove_permission_v2");
        com.bytedance.ee.bear.middleground.comment.control.y r17 = this.actionControl;
        String r18 = r8.getUser_id();
        CommentBean r19 = this.commentBean;
        if (r19 == null) goto L60;
        List<String> r20 = r19.getParticipantList();
    L61:
        boolean r21 = r17.t(r18, r20);
        if (this.config.u == true) goto L77;
        if (r16 == true) goto L65;
        if (r21 == false) goto L77;
    L65:
        CommentBean r22 = this.commentBean;
        if (r22 != null) goto L68;
    L70:
        r1 = false;
    L71:
        if (r1 == true) goto L77;
        r7.g.setVisibility(0);
        r7.e.setVisibility(0);
        if (r21 == false) goto L75;
        int r23 = UDColorUtils.getColor(((RecyclerView.ViewHolder) r7).itemView.getContext(), 2131102419);
    L76:
        r7.e.setColorFilter(r23, PorterDuff.Mode.SRC_IN);
        r7.e.setOnClickListener(new e(r21, r7, this, r8));
        return;
    L75:
        r23 = UDColorUtils.getColor(((RecyclerView.ViewHolder) r7).itemView.getContext(), 2131106610);
        goto L76
    L68:
        if (r22.isActionBlocked(CommentAction.QUOTE_MORE) != true) goto L70;
    L77:
        r7.g.setVisibility(8);
        r7.e.setVisibility(8);
        return;
    L60:
        r20 = null;
        goto L61
    L44:
        if (r12.length() == 0) goto L47;
        r13 = false;
        goto L48
    L19:
        if (r2.getCommentType() != 2) goto L21;
        r5 = true;
    L78:
        r7.g.setVisibility(8);
        r7.f.setVisibility(8);
        r7.e.setVisibility(8);
        r7.j.setVisibility(8);
        return;
    L9:
        if (r3.isCanPerformAction() == true) goto L11;
        r4 = true;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void onBindViewHolder(RecyclerView.ViewHolder r9, int r10, List<Object> r11) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        Intrinsics.checkNotNullParameter(r11, "payloads");
        StringBuilder r0 = new StringBuilder("onBindViewHolder: recyclerView = @recyclerView");
        RecyclerView r1 = this.mRecyclerView;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        r0.append(r3);
        r0.append(", position = ");
        r0.append(r10);
        r0.append(", payloads = ");
        r0.append(r11);
        tt5.a.h(TAG, r0.toString());
        if (r11.isEmpty() == true) goto L86;
        boolean r4 = r9 instanceof QuoteViewHolder;
        if (r4 == true) goto L86;
        if ((r9 instanceof PlaceHolderViewHolder) == true) goto L86;
        if ((r9 instanceof ReactionViewHolder) == true) goto L86;
        Bundle r5 = new Bundle();
        Iterator<Object> r12 = r11.iterator();
    L17:
        if (r12.hasNext() == false) goto L19;
        Object r6 = r12.next();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.os.Bundle");
        r5.putAll((Bundle) r6);
        goto L17
    L19:
        CommentBean.CommentDetail r13 = (CommentBean.CommentDetail) ListProtector.get(this.commentDetails, r10);
        if ((r9 instanceof ContentViewHolder) == false) goto L79;
        ContentViewHolder r14 = (ContentViewHolder) r9;
        RichTextInjector.b(r14.f, null, null, false, 24);
        RichTextInjector.b(r14.a, null, null, false, 24);
        SharePermissionViewModel r7 = this.sharePermissionViewModel;
        if (r7 == null) goto L24;
        AppCompatTextView r8 = r14.f;
        int r15 = SharePermissionViewModel.j;
        r7.i(r8, true, null);
    L24:
        SharePermissionViewModel r16 = this.sharePermissionViewModel;
        if (r16 == null) goto L27;
        AppCompatTextView r17 = r14.a;
        int r18 = SharePermissionViewModel.j;
        r16.i(r17, true, null);
    L27:
        r14.u = r13;
        int r19 = CommentDiffUtils.a;
        if (r5.getInt(CardAdapter.TEXT, 0) != 1) goto L31;
        setContent(r14, r13, r10);
        setTime(r13, r14);
    L31:
        if (r5.getInt("TIME", 0) != 1) goto L34;
        setTime(r13, r14);
    L34:
        if (r5.getInt(CardAdapter.REACTION, 0) != 1) goto L37;
        setReaction(r14, r13);
        setMore(r14, r13);
    L37:
        if (r5.getInt("EDITSTATUS", 0) != 1) goto L40;
        setBackGround(r14, r13);
    L40:
        if (r5.getInt("MORE", 0) != 1) goto L43;
        setMore(r14, r13);
    L43:
        if (r5.getInt(CardAdapter.SENDINGSTATUS, 0) != 1) goto L46;
        setContentLoadingOrFailStatus(r14, r13);
        setMore(r14, r13);
    L46:
        if (r5.getInt("ANIMSTATUS", 0) != 1) goto L49;
        setAnim(r14, r13);
    L49:
        if (r5.getInt("NAME", 0) != 1) goto L52;
        r14.d.setText(r13.getName());
        setAvatar(r14, r13);
    L52:
        if (r5.getInt("TRANSLATE", 0) != 1) goto L55;
        setContent(r14, r13, r10);
        setTranslateIcon(r14, r13);
        setTranslateContent(r14, r13, r10);
        setMore(r14, r13);
    L55:
        if (r5.getInt("SMART_REPLY", 0) != 1) goto L58;
        setSmartAIReplyPreview(r14, r13);
    L58:
        if (r5.getInt("ACTIVITY_CONFIGURATION", 0) != 1) goto L60;
        boolean r110 = true;
    L62:
        if (r5.getInt("IMAGE", 0) != 1) goto L64;
        setCommentImageList(r14, r13);
    L78:
        setRetryView(r14, r13);
        return;
    L64:
        if (r110 == false) goto L78;
        CommentBean.CommentDetail.ExtraEntity r111 = r13.getExtra();
        if (r111 == null) goto L70;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r112 = r111.getImage_list();
        if (r112 == null) goto L70;
        int r113 = r112.size();
    L71:
        if (r113 <= 0) goto L78;
        updateImageSize();
        CommentBean.CommentDetail.ExtraEntity r114 = r13.getExtra();
        if (r114 == null) goto L77;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r115 = r114.getImage_list();
        if (r115 == null) goto L77;
        r2 = r115.size();
    L77:
        r14.W3(r2);
        r14.t.notifyDataSetChanged();
    L70:
        r113 = 0;
        goto L71
    L60:
        r110 = false;
        goto L62
    L79:
        if (r4 == false) goto L90;
        int r20 = CommentDiffUtils.a;
        if (r5.getInt("QUOTE_MENU", 0) != 1) goto L84;
        bindQuoteMenu((QuoteViewHolder) r9, r13, r10);
    L84:
        if (r5.getInt(CardAdapter.TEXT, 0) != 1) goto L91;
        bindQuoteText((QuoteViewHolder) r9, r13);
        return;
    L91:
        return;
    L90:
        return;
    L86:
        onBindViewHolder(r9, r10);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setContent(ContentViewHolder r7, CommentBean.CommentDetail r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        AppCompatTextView r1 = r7.f;
        if (TextUtils.isEmpty(r8.getContent()) == true) goto L5;
        int r2 = 0;
    L6:
        r1.setVisibility(r2);
        Map<String, Boolean> r3 = nf5.a.a;
        TranslateConfig r4 = this.config.x;
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r8, "item");
        boolean r0 = nf5.a.g(r4, r8.getReply_id(), r8.getTranslate_status());
        if (r0 == false) goto L9;
        String r5 = r8.getTranslate_content();
    L11:
        if ((r7 instanceof RevisionViewHolder) == false) goto L29;
        if (r0 == false) goto L20;
        CommentBean r6 = this.commentBean;
        if (r6 == null) goto L27;
        CommentBean.Extra r10 = r6.getExtra();
        if (r10 == null) goto L27;
        RevisionExtra r11 = r10.getRevisionExtra();
        if (r11 == null) goto L27;
        String r12 = r11.getRevisionTitleTranslate();
    L28:
        r5 = r12 + r5;
        RichTextInjector.a(r7.f, this.userIds, createContentLinkClickListener(r8.getComment_id(), getCommentVisibility(r8), r9), getRevisionTextStylesOrNull(r12), this.config.U);
    L30:
        r7.f.setMovementMethod(com.bytedance.ee.bear.facade.common.widget.u.a());
        r7.f.setRawString(r5);
        SharePermissionViewModel r13 = this.sharePermissionViewModel;
        if (r13 == null) goto L33;
        AppCompatTextView r14 = r7.f;
        int r15 = SharePermissionViewModel.j;
        r13.i(r14, true, null);
    L33:
        adjustPosition(r7.f, r7.b);
        r7.f.post(new o(this, r7));
        return;
    L27:
        r12 = null;
        goto L28
    L20:
        CommentBean r16 = this.commentBean;
        if (r16 == null) goto L27;
        CommentBean.Extra r17 = r16.getExtra();
        if (r17 == null) goto L27;
        RevisionExtra r18 = r17.getRevisionExtra();
        if (r18 == null) goto L27;
        r12 = r18.getRevisionTitle();
        goto L28
    L29:
        RichTextInjector.b(r7.f, this.userIds, createContentLinkClickListener(r8.getComment_id(), getCommentVisibility(r8), r9), this.config.U, 8);
        goto L30
    L9:
        r5 = r8.getContent();
        goto L11
    L5:
        r2 = 8;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setTranslateContent(ContentViewHolder r7, CommentBean.CommentDetail r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        r7.a.setMaxWidth(com.bytedance.ee.util.ui.n.v() - com.bytedance.ee.util.ui.n.d(86));
        Map<String, Boolean> r1 = nf5.a.a;
        TranslateConfig r2 = this.config.x;
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r8, "item");
        if (nf5.a.f(r2, r8.getReply_id(), r8.getTranslate_status()) == false) goto L31;
        TranslateConfig r3 = this.config.x;
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r8, "item");
        boolean r0 = nf5.a.a(r3, r8.getReply_id());
        if (r0 == false) goto L7;
        String r4 = r8.getContent();
    L9:
        if ((r7 instanceof RevisionViewHolder) == false) goto L27;
        if (r0 == false) goto L18;
        CommentBean r5 = this.commentBean;
        if (r5 == null) goto L25;
        CommentBean.Extra r6 = r5.getExtra();
        if (r6 == null) goto L25;
        RevisionExtra r10 = r6.getRevisionExtra();
        if (r10 == null) goto L25;
        String r11 = r10.getRevisionTitle();
    L26:
        r4 = r11 + r4;
        RichTextInjector.a(r7.a, this.userIds, createContentLinkClickListener(r8.getComment_id(), getCommentVisibility(r8), r9), getRevisionTextStylesOrNull(r11), this.config.U);
    L28:
        r7.a.setMovementMethod(com.bytedance.ee.bear.facade.common.widget.u.a());
        r7.a.setVisibility(0);
        r7.a.setRawString(r4);
        SharePermissionViewModel r12 = this.sharePermissionViewModel;
        if (r12 == null) goto L32;
        AppCompatTextView r13 = r7.a;
        int r14 = SharePermissionViewModel.j;
        r12.i(r13, true, null);
    L32:
        adjustPosition(r7.a, r7.b);
        return;
    L25:
        r11 = null;
        goto L26
    L18:
        CommentBean r15 = this.commentBean;
        if (r15 == null) goto L25;
        CommentBean.Extra r16 = r15.getExtra();
        if (r16 == null) goto L25;
        RevisionExtra r17 = r16.getRevisionExtra();
        if (r17 == null) goto L25;
        r11 = r17.getRevisionTitleTranslate();
        goto L26
    L27:
        RichTextInjector.b(r7.a, this.userIds, createContentLinkClickListener(r8.getComment_id(), getCommentVisibility(r8), r9), this.config.U, 8);
        goto L28
    L7:
        r4 = r8.getTranslate_content();
        goto L9
    L31:
        r7.a.setVisibility(8);
        goto L32
    }

    public static final /* synthetic */ void access$handleFilePreviewPermission(CardAdapter2 r0, ContentViewHolder r1, boolean r2, boolean r3) {
        r0.handleFilePreviewPermission(r1, r2, r3);
    }

    private final void bindCollaboratorIcon(QuoteViewHolder r3, boolean r4, int r5, int r6, Drawable r7) {
        LKUIRoundedImageView2 r0 = r3.a;
        Drawable r8 = AppCompatResources.getDrawable(((RecyclerView.ViewHolder) r3).itemView.getContext(), r5);
        if (r8 == null) goto L5;
        r8.setTint(UDColorUtils.getColor(((RecyclerView.ViewHolder) r3).itemView.getContext(), r6));
    L6:
        r0.setBorderDrawable(r8);
        r3.a.setBackground(r7);
        r3.a.setOnClickListener(new b(r4, r3));
        return;
    L5:
        r8 = null;
        goto L6
    }

    public static /* synthetic */ void showReaction$default(CardAdapter2 r0, ContentViewHolder r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = 1;
    L6:
        r0.showReaction(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showReaction");
    }

    public void showCardMoreMenuList(QuoteViewHolder r9, CommentBean.CommentDetail r10, ICardAdapter r11, int r12, List<String> r13) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(r11, "cardAdapter");
        this.actionControl.y(((RecyclerView.ViewHolder) r9).itemView, r10, this, r12, r13, true);
    }

    public CardAdapter2(com.bytedance.ee.bear.middleground.comment.uitls.p r2, List<String> r3, com.bytedance.ee.bear.middleground.comment.control.z r4, com.bytedance.ee.bear.middleground.comment.control.y r5, SharePermissionViewModel r6, com.bytedance.ee.bear.middleground.comment.card.d r7, String r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "userIds");
        Intrinsics.checkNotNullParameter(r4, "commentListeners");
        Intrinsics.checkNotNullParameter(r5, "actionControl");
        Intrinsics.checkNotNullParameter(r7, "cardDataViewModel");
        Intrinsics.checkNotNullParameter(r8, "language");
        this.config = r2;
        this.userIds = r3;
        this.commentListeners = r4;
        this.actionControl = r5;
        this.sharePermissionViewModel = r6;
        this.cardDataViewModel = r7;
        this.language = r8;
        this.clickLink = r9;
        this.uiState = new com.bytedance.ee.bear.middleground.comment.export.w();
        this.commentDetails = new ArrayList();
        this.imageItemMargin = v2c.a.a(r2.getActivity(), 4.0f);
        this.adminCanPreview = !r2.T;
        this.minWidthInWideScreen = com.bytedance.ee.util.ui.n.c(376.0f);
        if (r2.T == true) goto L8;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        this.adminCanPreview = r2.S.c(r2.k.b, r2.i, "VIEW").getAllow();
        goto L8
    L7:
        bf5.a r10 = r2.S;
        int r11 = r2.k.b;
        this.adminCanPreview = r10.b(r2.i).a;
    L8:
        r4.a().add(new AnonymousClass1(this));
        this.onClickImageItem = new CardAdapter2$onClickImageItem$1(this);
    }
}
