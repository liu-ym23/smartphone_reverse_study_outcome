package com.larus.bmhome.chat.resp;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.bot.AnswerAction;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotDigitalHumanData;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SceneModelList;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.larus.utils.gson.TimeTransformAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Deprecated(message = "old data flow")
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b±\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 õ\u00012\u00020\u0001:\u0002õ\u0001B\u009d\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;\u0012\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0\u0014\u0012\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014\u0012\b\b\u0002\u0010>\u001a\u00020\u0003¢\u0006\u0004\b?\u0010@J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¿\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Á\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010LJ\u0011\u0010Â\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010QJ\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010Å\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010LJ\n\u0010Æ\u0001\u001a\u00020\nHÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010È\u0001\u001a\u00020\nHÆ\u0003J\u0012\u0010É\u0001\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\f\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010Í\u0001\u001a\u00020\bHÆ\u0003J\n\u0010Î\u0001\u001a\u00020\nHÆ\u0003J\f\u0010Ï\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ð\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\f\u0010Ñ\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\f\u0010Ò\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ô\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\u0012\u0010Õ\u0001\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014HÆ\u0003J\u0012\u0010Ö\u0001\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014HÆ\u0003J\u0012\u0010×\u0001\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0014HÆ\u0003J\f\u0010Ø\u0001\u001a\u0004\u0018\u00010+HÆ\u0003J\f\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Û\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Þ\u0001\u001a\u0004\u0018\u000102HÆ\u0003J\f\u0010ß\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010à\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010LJ\f\u0010á\u0001\u001a\u0004\u0018\u000106HÆ\u0003J\f\u0010â\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ã\u0001\u001a\u0004\u0018\u000109HÆ\u0003J\f\u0010ä\u0001\u001a\u0004\u0018\u00010;HÆ\u0003J\u0010\u0010å\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u0014HÆ\u0003J\u0010\u0010æ\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014HÆ\u0003J\n\u0010ç\u0001\u001a\u00020\u0003HÆ\u0003J¦\u0004\u0010è\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\n2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00142\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00142\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00142\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\b\b\u0002\u0010>\u001a\u00020\u0003HÆ\u0001¢\u0006\u0003\u0010é\u0001J\u0007\u0010ê\u0001\u001a\u00020\nJ\u0016\u0010ë\u0001\u001a\u00020\b2\n\u0010ì\u0001\u001a\u0005\u0018\u00010í\u0001HÖ\u0003J\n\u0010î\u0001\u001a\u00020\nHÖ\u0001J\n\u0010ï\u0001\u001a\u00020\u0003HÖ\u0001J\u001b\u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010ò\u0001\u001a\u00030ó\u00012\u0007\u0010ô\u0001\u001a\u00020\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010B\"\u0004\bF\u0010DR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010B\"\u0004\bH\u0010DR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010B\"\u0004\bJ\u0010DR\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010O\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010T\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010O\u001a\u0004\b]\u0010L\"\u0004\b^\u0010NR\u001e\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010B\"\u0004\bd\u0010DR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010`\"\u0004\bf\u0010bR&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010B\"\u0004\bl\u0010DR\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001e\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010n\"\u0004\br\u0010pR\u001e\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010`\"\u0004\bx\u0010bR \u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010B\"\u0004\bz\u0010DR \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R#\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R$\u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\"\u0010#\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010B\"\u0005\b\u0088\u0001\u0010DR$\u0010$\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R(\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010h\"\u0005\b\u008e\u0001\u0010jR(\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010h\"\u0005\b\u0090\u0001\u0010jR(\u0010)\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010h\"\u0005\b\u0092\u0001\u0010jR$\u0010*\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\"\u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010B\"\u0005\b\u0098\u0001\u0010DR\"\u0010-\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010B\"\u0005\b\u009a\u0001\u0010DR\"\u0010.\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010B\"\u0005\b\u009c\u0001\u0010DR\"\u0010/\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010B\"\u0005\b\u009e\u0001\u0010DR\"\u00100\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010B\"\u0005\b \u0001\u0010DR$\u00101\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\"\u00103\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010B\"\u0005\b¦\u0001\u0010DR$\u00104\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010O\u001a\u0005\b§\u0001\u0010L\"\u0005\b¨\u0001\u0010NR$\u00105\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R\"\u00107\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010B\"\u0005\b®\u0001\u0010DR$\u00108\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R$\u0010:\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R\"\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010h\"\u0005\b¸\u0001\u0010jR\"\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010h\"\u0005\bº\u0001\u0010jR\u001c\u0010>\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b»\u0001\u0010B\"\u0005\b¼\u0001\u0010D¨\u0006ö\u0001"}, d2 = {"Lcom/larus/bmhome/chat/resp/BotInfo;", "Landroid/os/Parcelable;", "id", "", "name", "modelDescription", "humanDescription", "messagePush", "", "privateStatus", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/im/bean/bot/ModelItem;", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "muted", "botType", "botFeatureLabel", "botMode", "botConf", "", "Lcom/larus/im/bean/bot/BotConfItem;", "editPos", "createTime", "", UserInfo.UPDATE_TIME, "disabled", "recommendIndex", "disabledTag", "shareInfo", "Lcom/larus/im/bean/bot/ShareInfo;", "botCreatorInfo", "Lcom/larus/im/bean/bot/BotCreatorInfo;", "botStatus", "Lcom/larus/bmhome/chat/resp/BotStatus;", "bio", "conversationPage", "Lcom/larus/im/bean/bot/ConversationPage;", "answerActions", "Lcom/larus/im/bean/bot/AnswerAction;", "menuActions", "streamingAnswerActions", "iconImage", "Lcom/larus/im/bean/bot/BotIconImage;", "iconUrl", "iconUri", "bgImgUrl", "bgImgColor", "iconPrompt", "switchConfInfo", "Lcom/larus/bmhome/chat/resp/BotSwitchConfInfo;", "callerName", "callerNameSetting", "digitalHumanData", "Lcom/larus/im/bean/bot/BotDigitalHumanData;", "conversationID", "sceneModelList", "Lcom/larus/im/bean/bot/SceneModelList;", "firstMet", "Lcom/larus/im/bean/bot/FirstMet;", "modelList", "voiceList", "owner", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/Boolean;ILjava/lang/String;ILjava/util/List;Ljava/lang/String;JJZILjava/lang/String;Lcom/larus/im/bean/bot/ShareInfo;Lcom/larus/im/bean/bot/BotCreatorInfo;Lcom/larus/bmhome/chat/resp/BotStatus;Ljava/lang/String;Lcom/larus/im/bean/bot/ConversationPage;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/larus/im/bean/bot/BotIconImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/resp/BotSwitchConfInfo;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/BotDigitalHumanData;Ljava/lang/String;Lcom/larus/im/bean/bot/SceneModelList;Lcom/larus/im/bean/bot/FirstMet;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "getModelDescription", "setModelDescription", "getHumanDescription", "setHumanDescription", "getMessagePush", "()Ljava/lang/Boolean;", "setMessagePush", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPrivateStatus", "()Ljava/lang/Integer;", "setPrivateStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getModel", "()Lcom/larus/im/bean/bot/ModelItem;", "setModel", "(Lcom/larus/im/bean/bot/ModelItem;)V", "getVoice", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "setVoice", "(Lcom/larus/im/bean/bot/SpeakerVoice;)V", "getMuted", "setMuted", "getBotType", "()I", "setBotType", "(I)V", "getBotFeatureLabel", "setBotFeatureLabel", "getBotMode", "setBotMode", "getBotConf", "()Ljava/util/List;", "setBotConf", "(Ljava/util/List;)V", "getEditPos", "setEditPos", "getCreateTime", "()J", "setCreateTime", "(J)V", "getUpdateTime", "setUpdateTime", "getDisabled", "()Z", "setDisabled", "(Z)V", "getRecommendIndex", "setRecommendIndex", "getDisabledTag", "setDisabledTag", "getShareInfo", "()Lcom/larus/im/bean/bot/ShareInfo;", "setShareInfo", "(Lcom/larus/im/bean/bot/ShareInfo;)V", "getBotCreatorInfo", "()Lcom/larus/im/bean/bot/BotCreatorInfo;", "setBotCreatorInfo", "(Lcom/larus/im/bean/bot/BotCreatorInfo;)V", "getBotStatus", "()Lcom/larus/bmhome/chat/resp/BotStatus;", "setBotStatus", "(Lcom/larus/bmhome/chat/resp/BotStatus;)V", "getBio", "setBio", "getConversationPage", "()Lcom/larus/im/bean/bot/ConversationPage;", "setConversationPage", "(Lcom/larus/im/bean/bot/ConversationPage;)V", "getAnswerActions", "setAnswerActions", "getMenuActions", "setMenuActions", "getStreamingAnswerActions", "setStreamingAnswerActions", "getIconImage", "()Lcom/larus/im/bean/bot/BotIconImage;", "setIconImage", "(Lcom/larus/im/bean/bot/BotIconImage;)V", "getIconUrl", "setIconUrl", "getIconUri", "setIconUri", "getBgImgUrl", "setBgImgUrl", "getBgImgColor", "setBgImgColor", "getIconPrompt", "setIconPrompt", "getSwitchConfInfo", "()Lcom/larus/bmhome/chat/resp/BotSwitchConfInfo;", "setSwitchConfInfo", "(Lcom/larus/bmhome/chat/resp/BotSwitchConfInfo;)V", "getCallerName", "setCallerName", "getCallerNameSetting", "setCallerNameSetting", "getDigitalHumanData", "()Lcom/larus/im/bean/bot/BotDigitalHumanData;", "setDigitalHumanData", "(Lcom/larus/im/bean/bot/BotDigitalHumanData;)V", "getConversationID", "setConversationID", "getSceneModelList", "()Lcom/larus/im/bean/bot/SceneModelList;", "setSceneModelList", "(Lcom/larus/im/bean/bot/SceneModelList;)V", "getFirstMet", "()Lcom/larus/im/bean/bot/FirstMet;", "setFirstMet", "(Lcom/larus/im/bean/bot/FirstMet;)V", "getModelList", "setModelList", "getVoiceList", "setVoiceList", "getOwner", "setOwner", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/Boolean;ILjava/lang/String;ILjava/util/List;Ljava/lang/String;JJZILjava/lang/String;Lcom/larus/im/bean/bot/ShareInfo;Lcom/larus/im/bean/bot/BotCreatorInfo;Lcom/larus/bmhome/chat/resp/BotStatus;Ljava/lang/String;Lcom/larus/im/bean/bot/ConversationPage;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/larus/im/bean/bot/BotIconImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/resp/BotSwitchConfInfo;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/BotDigitalHumanData;Ljava/lang/String;Lcom/larus/im/bean/bot/SceneModelList;Lcom/larus/im/bean/bot/FirstMet;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/larus/bmhome/chat/resp/BotInfo;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotInfo implements Parcelable {
    public static final Parcelable.Creator<BotInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient List<ModelItem> f308547a;

    @SerializedName("answer_actions")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<AnswerAction> answerActions;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient List<SpeakerVoice> f308548b;

    @SerializedName("bg_img_avg_hue")
    private String bgImgColor;

    @SerializedName("bg_img_url")
    private String bgImgUrl;

    @SerializedName("bio")
    private String bio;

    @SerializedName("bot_conf")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<BotConfItem> botConf;

    @SerializedName("creator_info")
    private BotCreatorInfo botCreatorInfo;

    @SerializedName("bot_feature_label")
    private String botFeatureLabel;

    @SerializedName("bot_mode")
    private int botMode;

    @SerializedName("bot_stats")
    private BotStatus botStatus;

    @SerializedName("bot_type")
    private int botType;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient String f308549c;

    @SerializedName(Constant.KEY_CALL_NAME)
    private String callerName;

    @SerializedName("caller_name_setting")
    private Boolean callerNameSetting;

    @SerializedName("conversation_id")
    private String conversationID;

    @SerializedName(CommentPublishScene.CONVERSATION_PAGE)
    private com.larus.im.bean.bot.ConversationPage conversationPage;

    @SerializedName("create_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private long createTime;

    @SerializedName("digital_human_data")
    private BotDigitalHumanData digitalHumanData;

    @SerializedName("disabled")
    private boolean disabled;

    @SerializedName("disabled_tag")
    private String disabledTag;

    @SerializedName("edit_pos")
    private String editPos;

    @SerializedName("first_met")
    private FirstMet firstMet;

    @SerializedName("description_for_human")
    private String humanDescription;

    @SerializedName("icon_image")
    private BotIconImage iconImage;

    @SerializedName("icon_prompt")
    private String iconPrompt;

    @SerializedName("icon_uri")
    private String iconUri;

    @SerializedName("icon_url")
    private String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f308550id;

    @SerializedName("hover_answer_actions")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<AnswerAction> menuActions;

    @SerializedName("message_push")
    private Boolean messagePush;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private ModelItem model;

    @SerializedName("description_for_model")
    private String modelDescription;

    @SerializedName("muted")
    private Boolean muted;

    @SerializedName("name")
    private String name;

    @SerializedName("private_status")
    private Integer privateStatus;

    @SerializedName("recommend_index")
    private int recommendIndex;

    @SerializedName("call_model_list")
    private SceneModelList sceneModelList;

    @SerializedName("share_info")
    private ShareInfo shareInfo;

    @SerializedName("streaming_answer_actions")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<AnswerAction> streamingAnswerActions;

    @SerializedName("switch_conf")
    private BotSwitchConfInfo switchConfInfo;

    @SerializedName("update_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private long updateTime;

    @SerializedName("voice_type")
    private SpeakerVoice voice;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<BotInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotInfo createFromParcel(Parcel r510) {
            Intrinsics.checkNotNullParameter(r510, "parcel");
            String r100 = r510.readString();
            String r101 = r510.readString();
            String r102 = r510.readString();
            String r103 = r510.readString();
            if (r510.readInt() != 0) goto L6;
            Boolean r104 = null;
        L11:
            if (r510.readInt() != 0) goto L13;
            Integer r105 = null;
        L14:
            ModelItem r110 = (ModelItem) r510.readSerializable();
            SpeakerVoice r111 = (SpeakerVoice) r510.readSerializable();
            if (r510.readInt() != 0) goto L18;
            Boolean r112 = null;
        L22:
            int r113 = r510.readInt();
            String r114 = r510.readString();
            int r115 = r510.readInt();
            if (r510.readInt() != 0) goto L25;
            ArrayList r116 = null;
        L29:
            String r210 = r510.readString();
            long r211 = r510.readLong();
            long r212 = r510.readLong();
            if (r510.readInt() == 0) goto L32;
            boolean r213 = true;
        L33:
            int r214 = r510.readInt();
            String r215 = r510.readString();
            ShareInfo r216 = (ShareInfo) r510.readSerializable();
            BotCreatorInfo r217 = (BotCreatorInfo) r510.readSerializable();
            if (r510.readInt() != 0) goto L36;
            BotStatus r106 = null;
        L37:
            BotStatus r310 = r106;
            String r311 = r510.readString();
            com.larus.im.bean.bot.ConversationPage r312 = (com.larus.im.bean.bot.ConversationPage) r510.readSerializable();
            if (r510.readInt() != 0) goto L40;
            ArrayList r313 = null;
        L45:
            if (r510.readInt() != 0) goto L47;
            ArrayList r314 = null;
        L52:
            if (r510.readInt() != 0) goto L54;
            ArrayList r315 = null;
        L58:
            BotIconImage r316 = (BotIconImage) r510.readSerializable();
            String r317 = r510.readString();
            String r318 = r510.readString();
            String r319 = r510.readString();
            String r410 = r510.readString();
            String r411 = r510.readString();
            if (r510.readInt() != 0) goto L61;
            BotSwitchConfInfo r107 = null;
        L62:
            BotSwitchConfInfo r412 = r107;
            String r413 = r510.readString();
            if (r510.readInt() != 0) goto L66;
            Boolean r414 = null;
        L70:
            BotDigitalHumanData r415 = (BotDigitalHumanData) r510.readSerializable();
            String r416 = r510.readString();
            SceneModelList r417 = (SceneModelList) r510.readSerializable();
            FirstMet r418 = (FirstMet) r510.readSerializable();
            int r108 = r510.readInt();
            ArrayList r109 = new ArrayList(r108);
            int r117 = 0;
        L71:
            if (r117 == r108) goto L73;
            r109.add(r510.readSerializable());
            r117 = r117 + 1;
            goto L71
        L73:
            int r118 = r510.readInt();
            ArrayList r119 = new ArrayList(r118);
            int r120 = 0;
        L74:
            if (r120 == r118) goto L76;
            int r121 = r118;
            r119.add(r510.readSerializable());
            r120 = r120 + 1;
            r118 = r121;
            goto L74
        L76:
            Boolean r122 = r104;
            Integer r123 = r105;
            Boolean r124 = r112;
            ArrayList r125 = r116;
            boolean r218 = r213;
            ArrayList r219 = r313;
            ArrayList r320 = r314;
            ArrayList r321 = r315;
            Boolean r419 = r414;
            return new BotInfo(r100, r101, r102, r103, r122, r123, r110, r111, r124, r113, r114, r115, r125, r210, r211, r212, r218, r214, r215, r216, r217, r310, r311, r312, r219, r320, r321, r316, r317, r318, r319, r410, r411, r412, r413, r419, r415, r416, r417, r418, r109, r119, r510.readString());
        L66:
            if (r510.readInt() == 0) goto L68;
            boolean r126 = true;
        L69:
            r414 = Boolean.valueOf(r126);
            goto L70
        L68:
            r126 = false;
            goto L69
        L61:
            r107 = BotSwitchConfInfo.CREATOR.createFromParcel(r510);
            goto L62
        L54:
            int r127 = r510.readInt();
            ArrayList r128 = new ArrayList(r127);
            int r129 = 0;
        L55:
            if (r129 == r127) goto L57;
            int r322 = r127;
            r128.add(r510.readSerializable());
            r129 = r129 + 1;
            r127 = r322;
            goto L55
        L57:
            r315 = r128;
            goto L58
        L47:
            int r130 = r510.readInt();
            ArrayList r131 = new ArrayList(r130);
            int r132 = 0;
        L48:
            if (r132 == r130) goto L50;
            int r323 = r130;
            r131.add(r510.readSerializable());
            r132 = r132 + 1;
            r130 = r323;
            goto L48
        L50:
            r314 = r131;
            goto L52
        L40:
            int r133 = r510.readInt();
            ArrayList r134 = new ArrayList(r133);
            int r135 = 0;
        L41:
            if (r135 == r133) goto L43;
            int r324 = r133;
            r134.add(r510.readSerializable());
            r135 = r135 + 1;
            r133 = r324;
            goto L41
        L43:
            r313 = r134;
            goto L45
        L36:
            r106 = BotStatus.CREATOR.createFromParcel(r510);
            goto L37
        L32:
            r213 = false;
            goto L33
        L25:
            int r136 = r510.readInt();
            ArrayList r137 = new ArrayList(r136);
            int r138 = 0;
        L26:
            if (r138 == r136) goto L28;
            int r139 = r136;
            r137.add(r510.readSerializable());
            r138 = r138 + 1;
            r136 = r139;
            goto L26
        L28:
            r116 = r137;
            goto L29
        L18:
            if (r510.readInt() == 0) goto L20;
            boolean r140 = true;
        L21:
            r112 = Boolean.valueOf(r140);
            goto L22
        L20:
            r140 = false;
            goto L21
        L13:
            r105 = Integer.valueOf(r510.readInt());
            goto L14
        L6:
            if (r510.readInt() == 0) goto L8;
            boolean r141 = true;
        L9:
            r104 = Boolean.valueOf(r141);
            goto L11
        L8:
            r141 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final BotInfo[] newArray(int r100) {
            return new BotInfo[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotInfo) == true) goto L8;
        return false;
    L8:
        BotInfo r101 = (BotInfo) r100;
        if (Intrinsics.areEqual(this.f308550id, r101.f308550id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.modelDescription, r101.modelDescription) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.humanDescription, r101.humanDescription) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messagePush, r101.messagePush) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.privateStatus, r101.privateStatus) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.voice, r101.voice) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.muted, r101.muted) == true) goto L36;
        return false;
    L36:
        if (this.botType == r101.botType) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.botFeatureLabel, r101.botFeatureLabel) == true) goto L42;
        return false;
    L42:
        if (this.botMode == r101.botMode) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.botConf, r101.botConf) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.editPos, r101.editPos) == true) goto L51;
        return false;
    L51:
        if (this.createTime == r101.createTime) goto L54;
        return false;
    L54:
        if (this.updateTime == r101.updateTime) goto L57;
        return false;
    L57:
        if (this.disabled == r101.disabled) goto L60;
        return false;
    L60:
        if (this.recommendIndex == r101.recommendIndex) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.disabledTag, r101.disabledTag) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.shareInfo, r101.shareInfo) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.botCreatorInfo, r101.botCreatorInfo) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.botStatus, r101.botStatus) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.bio, r101.bio) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.conversationPage, r101.conversationPage) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.answerActions, r101.answerActions) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.menuActions, r101.menuActions) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.streamingAnswerActions, r101.streamingAnswerActions) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.iconImage, r101.iconImage) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.iconUri, r101.iconUri) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.bgImgUrl, r101.bgImgUrl) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.bgImgColor, r101.bgImgColor) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.iconPrompt, r101.iconPrompt) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.switchConfInfo, r101.switchConfInfo) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.callerName, r101.callerName) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.callerNameSetting, r101.callerNameSetting) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.digitalHumanData, r101.digitalHumanData) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.conversationID, r101.conversationID) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.sceneModelList, r101.sceneModelList) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.firstMet, r101.firstMet) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.f308547a, r101.f308547a) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.f308548b, r101.f308548b) == true) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.f308549c, r101.f308549c) == true) goto L137;
        return false;
    L137:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f308550id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.modelDescription;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.humanDescription;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.messagePush;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.privateStatus;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        ModelItem r119 = this.model;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        SpeakerVoice r122 = this.voice;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.muted;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (((r124 + r126) * 31) + this.botType) * 31;
        String r128 = this.botFeatureLabel;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (((r127 + r129) * 31) + this.botMode) * 31;
        List<BotConfItem> r131 = this.botConf;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.editPos;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        long r137 = this.createTime;
        int r138 = (r136 + ((int) (r137 ^ (r137 >>> 32)))) * 31;
        long r139 = this.updateTime;
        int r140 = (r138 + ((int) (r139 ^ (r139 >>> 32)))) * 31;
        if (this.disabled == false) goto L53;
        int r141 = 1231;
    L54:
        int r142 = (((r140 + r141) * 31) + this.recommendIndex) * 31;
        String r143 = this.disabledTag;
        if (r143 != null) goto L57;
        int r144 = 0;
    L58:
        int r145 = (r142 + r144) * 31;
        ShareInfo r146 = this.shareInfo;
        if (r146 != null) goto L61;
        int r147 = 0;
    L62:
        int r148 = (r145 + r147) * 31;
        BotCreatorInfo r149 = this.botCreatorInfo;
        if (r149 != null) goto L65;
        int r150 = 0;
    L66:
        int r151 = (r148 + r150) * 31;
        BotStatus r152 = this.botStatus;
        if (r152 != null) goto L69;
        int r153 = 0;
    L70:
        int r154 = (r151 + r153) * 31;
        String r155 = this.bio;
        if (r155 != null) goto L73;
        int r156 = 0;
    L74:
        int r157 = (r154 + r156) * 31;
        com.larus.im.bean.bot.ConversationPage r158 = this.conversationPage;
        if (r158 != null) goto L77;
        int r159 = 0;
    L78:
        int r160 = (r157 + r159) * 31;
        List<AnswerAction> r161 = this.answerActions;
        if (r161 != null) goto L81;
        int r162 = 0;
    L82:
        int r163 = (r160 + r162) * 31;
        List<AnswerAction> r164 = this.menuActions;
        if (r164 != null) goto L85;
        int r165 = 0;
    L86:
        int r166 = (r163 + r165) * 31;
        List<AnswerAction> r167 = this.streamingAnswerActions;
        if (r167 != null) goto L89;
        int r168 = 0;
    L90:
        int r169 = (r166 + r168) * 31;
        BotIconImage r170 = this.iconImage;
        if (r170 != null) goto L93;
        int r171 = 0;
    L94:
        int r172 = (r169 + r171) * 31;
        String r173 = this.iconUrl;
        if (r173 != null) goto L97;
        int r174 = 0;
    L98:
        int r175 = (r172 + r174) * 31;
        String r176 = this.iconUri;
        if (r176 != null) goto L101;
        int r177 = 0;
    L102:
        int r178 = (r175 + r177) * 31;
        String r179 = this.bgImgUrl;
        if (r179 != null) goto L105;
        int r180 = 0;
    L106:
        int r181 = (r178 + r180) * 31;
        String r182 = this.bgImgColor;
        if (r182 != null) goto L109;
        int r183 = 0;
    L110:
        int r184 = (r181 + r183) * 31;
        String r185 = this.iconPrompt;
        if (r185 != null) goto L113;
        int r186 = 0;
    L114:
        int r187 = (r184 + r186) * 31;
        BotSwitchConfInfo r188 = this.switchConfInfo;
        if (r188 != null) goto L117;
        int r189 = 0;
    L118:
        int r190 = (r187 + r189) * 31;
        String r191 = this.callerName;
        if (r191 != null) goto L121;
        int r192 = 0;
    L122:
        int r193 = (r190 + r192) * 31;
        Boolean r194 = this.callerNameSetting;
        if (r194 != null) goto L125;
        int r195 = 0;
    L126:
        int r196 = (r193 + r195) * 31;
        BotDigitalHumanData r197 = this.digitalHumanData;
        if (r197 != null) goto L129;
        int r198 = 0;
    L130:
        int r199 = (r196 + r198) * 31;
        String r200 = this.conversationID;
        if (r200 != null) goto L133;
        int r201 = 0;
    L134:
        int r202 = (r199 + r201) * 31;
        SceneModelList r203 = this.sceneModelList;
        if (r203 != null) goto L137;
        int r204 = 0;
    L138:
        int r205 = (r202 + r204) * 31;
        FirstMet r206 = this.firstMet;
        if (r206 == null) goto L143;
        r101 = r206.hashCode();
    L143:
        return ((((((r205 + r101) * 31) + this.f308547a.hashCode()) * 31) + this.f308548b.hashCode()) * 31) + this.f308549c.hashCode();
    L137:
        r204 = r203.hashCode();
        goto L138
    L133:
        r201 = r200.hashCode();
        goto L134
    L129:
        r198 = r197.hashCode();
        goto L130
    L125:
        r195 = r194.hashCode();
        goto L126
    L121:
        r192 = r191.hashCode();
        goto L122
    L117:
        r189 = r188.hashCode();
        goto L118
    L113:
        r186 = r185.hashCode();
        goto L114
    L109:
        r183 = r182.hashCode();
        goto L110
    L105:
        r180 = r179.hashCode();
        goto L106
    L101:
        r177 = r176.hashCode();
        goto L102
    L97:
        r174 = r173.hashCode();
        goto L98
    L93:
        r171 = r170.hashCode();
        goto L94
    L89:
        r168 = r167.hashCode();
        goto L90
    L85:
        r165 = r164.hashCode();
        goto L86
    L81:
        r162 = r161.hashCode();
        goto L82
    L77:
        r159 = r158.hashCode();
        goto L78
    L73:
        r156 = r155.hashCode();
        goto L74
    L69:
        r153 = r152.hashCode();
        goto L70
    L65:
        r150 = r149.hashCode();
        goto L66
    L61:
        r147 = r146.hashCode();
        goto L62
    L57:
        r144 = r143.hashCode();
        goto L58
    L53:
        r141 = 1237;
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotInfo(id=" + this.f308550id + ", name=" + this.name + ", modelDescription=" + this.modelDescription + ", humanDescription=" + this.humanDescription + ", messagePush=" + this.messagePush + ", privateStatus=" + this.privateStatus + ", model=" + this.model + ", voice=" + this.voice + ", muted=" + this.muted + ", botType=" + this.botType + ", botFeatureLabel=" + this.botFeatureLabel + ", botMode=" + this.botMode + ", botConf=" + this.botConf + ", editPos=" + this.editPos + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", disabled=" + this.disabled + ", recommendIndex=" + this.recommendIndex + ", disabledTag=" + this.disabledTag + ", shareInfo=" + this.shareInfo + ", botCreatorInfo=" + this.botCreatorInfo + ", botStatus=" + this.botStatus + ", bio=" + this.bio + ", conversationPage=" + this.conversationPage + ", answerActions=" + this.answerActions + ", menuActions=" + this.menuActions + ", streamingAnswerActions=" + this.streamingAnswerActions + ", iconImage=" + this.iconImage + ", iconUrl=" + this.iconUrl + ", iconUri=" + this.iconUri + ", bgImgUrl=" + this.bgImgUrl + ", bgImgColor=" + this.bgImgColor + ", iconPrompt=" + this.iconPrompt + ", switchConfInfo=" + this.switchConfInfo + ", callerName=" + this.callerName + ", callerNameSetting=" + this.callerNameSetting + ", digitalHumanData=" + this.digitalHumanData + ", conversationID=" + this.conversationID + ", sceneModelList=" + this.sceneModelList + ", firstMet=" + this.firstMet + ", modelList=" + this.f308547a + ", voiceList=" + this.f308548b + ", owner=" + this.f308549c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f308550id);
        r100.writeString(this.name);
        r100.writeString(this.modelDescription);
        r100.writeString(this.humanDescription);
        Boolean r102 = this.messagePush;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.privateStatus;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeSerializable(this.model);
        r100.writeSerializable(this.voice);
        Boolean r104 = this.muted;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        r100.writeInt(this.botType);
        r100.writeString(this.botFeatureLabel);
        r100.writeInt(this.botMode);
        List<BotConfItem> r105 = this.botConf;
        if (r105 != null) goto L17;
        r100.writeInt(0);
    L21:
        r100.writeString(this.editPos);
        r100.writeLong(this.createTime);
        r100.writeLong(this.updateTime);
        r100.writeInt(this.disabled ? 1 : 0);
        r100.writeInt(this.recommendIndex);
        r100.writeString(this.disabledTag);
        r100.writeSerializable(this.shareInfo);
        r100.writeSerializable(this.botCreatorInfo);
        BotStatus r106 = this.botStatus;
        if (r106 != null) goto L24;
        r100.writeInt(0);
    L25:
        r100.writeString(this.bio);
        r100.writeSerializable(this.conversationPage);
        List<AnswerAction> r107 = this.answerActions;
        if (r107 != null) goto L28;
        r100.writeInt(0);
    L32:
        List<AnswerAction> r108 = this.menuActions;
        if (r108 != null) goto L35;
        r100.writeInt(0);
    L39:
        List<AnswerAction> r109 = this.streamingAnswerActions;
        if (r109 != null) goto L42;
        r100.writeInt(0);
    L46:
        r100.writeSerializable(this.iconImage);
        r100.writeString(this.iconUrl);
        r100.writeString(this.iconUri);
        r100.writeString(this.bgImgUrl);
        r100.writeString(this.bgImgColor);
        r100.writeString(this.iconPrompt);
        BotSwitchConfInfo r110 = this.switchConfInfo;
        if (r110 != null) goto L49;
        r100.writeInt(0);
    L50:
        r100.writeString(this.callerName);
        Boolean r111 = this.callerNameSetting;
        if (r111 != null) goto L53;
        r100.writeInt(0);
    L54:
        r100.writeSerializable(this.digitalHumanData);
        r100.writeString(this.conversationID);
        r100.writeSerializable(this.sceneModelList);
        r100.writeSerializable(this.firstMet);
        List<ModelItem> r112 = this.f308547a;
        r100.writeInt(r112.size());
        Iterator<ModelItem> r113 = r112.iterator();
    L56:
        if (r113.hasNext() == false) goto L58;
        r100.writeSerializable(r113.next());
        goto L56
    L58:
        List<SpeakerVoice> r114 = this.f308548b;
        r100.writeInt(r114.size());
        Iterator<SpeakerVoice> r115 = r114.iterator();
    L60:
        if (r115.hasNext() == false) goto L62;
        r100.writeSerializable(r115.next());
        goto L60
    L62:
        r100.writeString(this.f308549c);
        return;
    L53:
        r100.writeInt(1);
        r100.writeInt(r111.booleanValue() ? 1 : 0);
        goto L54
    L49:
        r100.writeInt(1);
        r110.writeToParcel(r100, r101);
        goto L50
    L42:
        r100.writeInt(1);
        r100.writeInt(r109.size());
        Iterator<AnswerAction> r116 = r109.iterator();
    L44:
        if (r116.hasNext() == false) goto L46;
        r100.writeSerializable(r116.next());
        goto L44
    L35:
        r100.writeInt(1);
        r100.writeInt(r108.size());
        Iterator<AnswerAction> r117 = r108.iterator();
    L37:
        if (r117.hasNext() == false) goto L39;
        r100.writeSerializable(r117.next());
        goto L37
    L28:
        r100.writeInt(1);
        r100.writeInt(r107.size());
        Iterator<AnswerAction> r118 = r107.iterator();
    L30:
        if (r118.hasNext() == false) goto L32;
        r100.writeSerializable(r118.next());
        goto L30
    L24:
        r100.writeInt(1);
        r106.writeToParcel(r100, r101);
        goto L25
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.size());
        Iterator<BotConfItem> r119 = r105.iterator();
    L19:
        if (r119.hasNext() == false) goto L21;
        r100.writeSerializable(r119.next());
        goto L19
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public BotInfo() {
        Boolean r310 = Boolean.FALSE;
        AppHost.Companion r100 = AppHost.f326268a;
        this("", "", "", "", r310, null, null, null, r310, 2, null, -1, null, "", r100.getAppClock().currentTimeMillis(), r100.getAppClock().currentTimeMillis() / ((long) 1000), false, 0, "null", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r310, null, null, null, null, CollectionsKt.emptyList(), CollectionsKt.emptyList(), "");
    }

    public BotInfo(String r100, String r101, String r102, String r110, Boolean r111, Integer r112, ModelItem r113, SpeakerVoice r114, Boolean r115, int r116, String r117, int r118, List<BotConfItem> r119, String r210, long r211, long r212, boolean r213, int r214, String r215, ShareInfo r216, BotCreatorInfo r217, BotStatus r310, String r311, com.larus.im.bean.bot.ConversationPage r312, List<AnswerAction> r313, List<AnswerAction> r314, List<AnswerAction> r315, BotIconImage r316, String r317, String r318, String r319, String r410, String r411, BotSwitchConfInfo r412, String r413, Boolean r414, BotDigitalHumanData r415, String r416, SceneModelList r417, FirstMet r418, List<ModelItem> r419, List<SpeakerVoice> r510, String r511) {
        Intrinsics.checkNotNullParameter(r419, "modelList");
        Intrinsics.checkNotNullParameter(r510, "voiceList");
        Intrinsics.checkNotNullParameter(r511, "owner");
        this.f308550id = r100;
        this.name = r101;
        this.modelDescription = r102;
        this.humanDescription = r110;
        this.messagePush = r111;
        this.privateStatus = r112;
        this.model = r113;
        this.voice = r114;
        this.muted = r115;
        this.botType = r116;
        this.botFeatureLabel = r117;
        this.botMode = r118;
        this.botConf = r119;
        this.editPos = r210;
        this.createTime = r211;
        this.updateTime = r212;
        this.disabled = r213;
        this.recommendIndex = r214;
        this.disabledTag = r215;
        this.shareInfo = r216;
        this.botCreatorInfo = r217;
        this.botStatus = r310;
        this.bio = r311;
        this.conversationPage = r312;
        this.answerActions = r313;
        this.menuActions = r314;
        this.streamingAnswerActions = r315;
        this.iconImage = r316;
        this.iconUrl = r317;
        this.iconUri = r318;
        this.bgImgUrl = r319;
        this.bgImgColor = r410;
        this.iconPrompt = r411;
        this.switchConfInfo = r412;
        this.callerName = r413;
        this.callerNameSetting = r414;
        this.digitalHumanData = r415;
        this.conversationID = r416;
        this.sceneModelList = r417;
        this.firstMet = r418;
        this.f308547a = r419;
        this.f308548b = r510;
        this.f308549c = r511;
    }
}
