package com.larus.bmhome.auth;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.auth.feature_config.model.FeatureDetailWithSwitch;
import com.larus.im.bean.bot.BotLanguage;
import com.larus.im.bean.bot.ModelItem;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.larus.utils.gson.TimeTransformAdapter;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0003\b\u0092\u0001\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0005\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010*\u001a\u00020+\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010.\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010%¢\u0006\u0004\bK\u0010LJ\n\u0010\u0093\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0005HÆ\u0003J\u0014\u0010\u0095\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\u0014\u0010\u0096\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007HÆ\u0003J\u0012\u0010\u0097\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0003J\u0012\u0010\u0098\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0003J\u0012\u0010\u0099\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0012\u0010¢\u0001\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0007HÆ\u0003J\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010eJ\n\u0010¤\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010¥\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010eJ\u0011\u0010¦\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010eJ\n\u0010§\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010'HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010)HÆ\u0003J\n\u0010¬\u0001\u001a\u00020+HÆ\u0003J\n\u0010\u00ad\u0001\u001a\u00020+HÆ\u0003J\u0018\u0010®\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010.HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u000102HÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u000107HÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u00010;HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010¹\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010¿\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010À\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010Á\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010Â\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010Ã\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010Å\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J¤\u0005\u0010Ç\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00072\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+2\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u00010%2\n\b\u0002\u00104\u001a\u0004\u0018\u00010%2\n\b\u0002\u00105\u001a\u0004\u0018\u00010%2\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u00010%2\n\b\u0002\u00109\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010%HÆ\u0001¢\u0006\u0003\u0010È\u0001J\u0015\u0010É\u0001\u001a\u00020\u00052\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010Ë\u0001\u001a\u00020+HÖ\u0001J\n\u0010Ì\u0001\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010RR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010RR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010RR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010RR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010XR\u0016\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010PR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010XR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010XR\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010RR\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010f\u001a\u0004\bd\u0010eR\u0016\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010PR\u001a\u0010 \u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010f\u001a\u0004\bh\u0010eR\u001a\u0010!\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010f\u001a\u0004\bi\u0010eR\u0016\u0010\"\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010PR\u0016\u0010#\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010PR\u0018\u0010$\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0018\u0010&\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0018\u0010(\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0016\u0010*\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0016\u0010,\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010sR$\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010.8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0018\u0010/\u001a\u0004\u0018\u0001008\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0018\u00101\u001a\u0004\u0018\u0001028\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0018\u00103\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010mR\u0018\u00104\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010mR\u0018\u00105\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010mR\u0018\u00106\u001a\u0004\u0018\u0001078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u0019\u00108\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010mR\u0019\u00109\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010mR\u001a\u0010:\u001a\u0004\u0018\u00010;8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010<\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010mR\u0019\u0010=\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010mR\u0019\u0010>\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010mR\u0019\u0010?\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010mR\u0019\u0010@\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010mR\u0019\u0010A\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010mR\u0019\u0010B\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010mR\u0019\u0010C\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010mR\u0019\u0010D\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010mR\u0019\u0010E\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010mR\u0019\u0010F\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010mR\u0019\u0010G\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010mR\u0019\u0010H\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010mR\u0019\u0010I\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010mR\u0019\u0010J\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010m¨\u0006Í\u0001"}, d2 = {"Lcom/larus/bmhome/auth/BasicLaunchInfo;", "", "timestamp", "", "debug", "", "modelList", "", "Lcom/larus/im/bean/bot/ModelItem;", "botLanguageList", "Lcom/larus/im/bean/bot/BotLanguage;", "botReportReasonList", "Lcom/larus/bmhome/auth/ReportReason;", "messageReportReasonList", "feedbackMeta", "Lcom/larus/bmhome/auth/FeedbackMeta;", "feedbackPlaceholder", "", "shareInfo", "Lcom/larus/bmhome/auth/shareInfo;", "discardLink", "saveChatHistoryPopupEnable", "showOpenNewConversationOnLaunch", "immersiveModeConfig", "Lcom/larus/bmhome/auth/ImmersConfig;", "actionBarShowBotConfig", "Lcom/larus/bmhome/auth/ActionBarConfig;", "highlightJump", "cocoSettingList", "Lcom/larus/bmhome/auth/CocoSetting;", "cocoSettingRegisterEnable", "debugEntranceEnable", "enablePromptDetail", "showResetBotSubjectInfo", "enableRedBadgeOpt", "appIconRedBadgeClosed", "appIconRedBadge", "Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "bgImageConfig", "Lcom/larus/bmhome/auth/BgImageConfig;", "creationConfig", "Lcom/larus/bmhome/auth/CreationConfig;", "createAvatarMaxUploadImgCnt", "", "createAvatarMinUploadImgCnt", "extra", "", "deepThinkingConfig", "Lcom/larus/bmhome/auth/DeepThinkingConfig;", "vlmImageSearchConf", "Lcom/larus/bmhome/auth/VlmImageSearchConf;", "personalizedRecommend", "inputWithSuggest", "discoverTag", "supportSearchAndGen", "Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;", "actionbarConfigurable", "appletThirdAuthSetting", LynxViewpagerItem.BIND_ON_ATTACH, "Lcom/larus/bmhome/auth/BasicAttachLaunchInfo;", "attachFile", "attachImgAlbum", "attachImgCamera", "attachSug", "attachmentArea", "previewImgCamera", "previewSug", "showBotLike", "showBotComment", "relatedVideo", "recordReplyMode", "defaultReplyModeMenu", "botCreateEnable", "defaultReplyModeMenuUseV3", "defaultActiveModeMenu", "<init>", "(JZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/larus/bmhome/auth/shareInfo;Ljava/lang/String;ZLjava/lang/String;Lcom/larus/bmhome/auth/ImmersConfig;Lcom/larus/bmhome/auth/ActionBarConfig;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;ZLjava/lang/Boolean;Ljava/lang/Boolean;ZZLcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/BgImageConfig;Lcom/larus/bmhome/auth/CreationConfig;IILjava/util/Map;Lcom/larus/bmhome/auth/DeepThinkingConfig;Lcom/larus/bmhome/auth/VlmImageSearchConf;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/BasicAttachLaunchInfo;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;)V", "getTimestamp", "()J", "getDebug", "()Z", "getModelList", "()Ljava/util/List;", "getBotLanguageList", "getBotReportReasonList", "getMessageReportReasonList", "getFeedbackMeta", "getFeedbackPlaceholder", "()Ljava/lang/String;", "getShareInfo", "()Lcom/larus/bmhome/auth/shareInfo;", "getDiscardLink", "getSaveChatHistoryPopupEnable", "getShowOpenNewConversationOnLaunch", "getImmersiveModeConfig", "()Lcom/larus/bmhome/auth/ImmersConfig;", "getActionBarShowBotConfig", "()Lcom/larus/bmhome/auth/ActionBarConfig;", "getHighlightJump", "getCocoSettingList", "getCocoSettingRegisterEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDebugEntranceEnable", "getEnablePromptDetail", "getShowResetBotSubjectInfo", "getEnableRedBadgeOpt", "getAppIconRedBadgeClosed", "getAppIconRedBadge", "()Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "getBgImageConfig", "()Lcom/larus/bmhome/auth/BgImageConfig;", "getCreationConfig", "()Lcom/larus/bmhome/auth/CreationConfig;", "getCreateAvatarMaxUploadImgCnt", "()I", "getCreateAvatarMinUploadImgCnt", "getExtra", "()Ljava/util/Map;", "getDeepThinkingConfig", "()Lcom/larus/bmhome/auth/DeepThinkingConfig;", "getVlmImageSearchConf", "()Lcom/larus/bmhome/auth/VlmImageSearchConf;", "getPersonalizedRecommend", "getInputWithSuggest", "getDiscoverTag", "getSupportSearchAndGen", "()Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;", "getActionbarConfigurable", "getAppletThirdAuthSetting", "getAttach", "()Lcom/larus/bmhome/auth/BasicAttachLaunchInfo;", "getAttachFile", "getAttachImgAlbum", "getAttachImgCamera", "getAttachSug", "getAttachmentArea", "getPreviewImgCamera", "getPreviewSug", "getShowBotLike", "getShowBotComment", "getRelatedVideo", "getRecordReplyMode", "getDefaultReplyModeMenu", "getBotCreateEnable", "getDefaultReplyModeMenuUseV3", "getDefaultActiveModeMenu", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "copy", "(JZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/larus/bmhome/auth/shareInfo;Ljava/lang/String;ZLjava/lang/String;Lcom/larus/bmhome/auth/ImmersConfig;Lcom/larus/bmhome/auth/ActionBarConfig;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;ZLjava/lang/Boolean;Ljava/lang/Boolean;ZZLcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/BgImageConfig;Lcom/larus/bmhome/auth/CreationConfig;IILjava/util/Map;Lcom/larus/bmhome/auth/DeepThinkingConfig;Lcom/larus/bmhome/auth/VlmImageSearchConf;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/BasicAttachLaunchInfo;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;)Lcom/larus/bmhome/auth/BasicLaunchInfo;", "equals", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e0 {

    @SerializedName("action_bar_show_bot_config")
    private final ActionBarConfig actionBarShowBotConfig;

    @SerializedName("actionbar_configurable")
    private final FeatureDetail actionbarConfigurable;

    @SerializedName("app_icon_red_button")
    private final FeatureDetail appIconRedBadge;

    @SerializedName("app_icon_red_badge_is_closed")
    private final boolean appIconRedBadgeClosed;

    @SerializedName("applet_third_auth_setting")
    private final FeatureDetail appletThirdAuthSetting;

    @SerializedName(LynxViewpagerItem.BIND_ON_ATTACH)
    private final d0 attach;

    @SerializedName("attach_file")
    private final FeatureDetail attachFile;

    @SerializedName("attach_img_album")
    private final FeatureDetail attachImgAlbum;

    @SerializedName("attach_img_camera")
    private final FeatureDetail attachImgCamera;

    @SerializedName("attach_sug")
    private final FeatureDetail attachSug;

    @SerializedName("attachment_area")
    private final FeatureDetail attachmentArea;

    @SerializedName("bg_image_config")
    private final BgImageConfig bgImageConfig;

    @SerializedName("bot_create_enable")
    private final FeatureDetail botCreateEnable;

    @SerializedName("bot_language_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<BotLanguage> botLanguageList;

    @SerializedName("bot_report_reason_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<ReportReason> botReportReasonList;

    @SerializedName("coco_setting_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<CocoSetting> cocoSettingList;

    @SerializedName("coco_setting_register_enable")
    private final Boolean cocoSettingRegisterEnable;

    @SerializedName("create_avatar_max_upload_img_cnt")
    private final int createAvatarMaxUploadImgCnt;

    @SerializedName("create_avatar_min_upload_img_cnt")
    private final int createAvatarMinUploadImgCnt;

    @SerializedName("creation_conf")
    private final CreationConfig creationConfig;

    @SerializedName("debug")
    private final boolean debug;

    @SerializedName("debug_entrance_enable")
    private final boolean debugEntranceEnable;

    @SerializedName("deep_thinking_config")
    private final DeepThinkingConfig deepThinkingConfig;

    @SerializedName("default_active_mode_menu")
    private final FeatureDetail defaultActiveModeMenu;

    @SerializedName("default_reply_mode_menu")
    private final FeatureDetail defaultReplyModeMenu;

    @SerializedName("default_reply_mode_menu_use_v3")
    private final FeatureDetail defaultReplyModeMenuUseV3;

    @SerializedName("discard_link")
    private final String discardLink;

    @SerializedName("discover_category")
    private final FeatureDetail discoverTag;

    @SerializedName("enable_prompt_detail")
    private final Boolean enablePromptDetail;

    @SerializedName("enable_red_badge_opt")
    private final boolean enableRedBadgeOpt;

    @SerializedName("extra")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> extra;

    @SerializedName("feedback_meta")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<FeedbackMeta> feedbackMeta;

    @SerializedName("feedback_placeholder")
    private final String feedbackPlaceholder;

    @SerializedName("highlight_jump")
    private final String highlightJump;

    @SerializedName("immersive_mode_config")
    private final ImmersConfig immersiveModeConfig;

    @SerializedName("input_with_suggest")
    private final FeatureDetail inputWithSuggest;

    @SerializedName("message_report_reason_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<ReportReason> messageReportReasonList;

    @SerializedName("model_list")
    private final List<ModelItem> modelList;

    @SerializedName("personalized_recommend")
    private final FeatureDetail personalizedRecommend;

    @SerializedName("preview_img_camera")
    private final FeatureDetail previewImgCamera;

    @SerializedName("preview_sug")
    private final FeatureDetail previewSug;

    @SerializedName("record_reply_mode")
    private final FeatureDetail recordReplyMode;

    @SerializedName("related_video")
    private final FeatureDetail relatedVideo;

    @SerializedName("save_chat_history_popup_enable")
    private final boolean saveChatHistoryPopupEnable;

    @SerializedName("share_info")
    private final shareInfo shareInfo;

    @SerializedName("show_bot_comment")
    private final FeatureDetail showBotComment;

    @SerializedName("show_bot_like")
    private final FeatureDetail showBotLike;

    @SerializedName("show_open_new_conversation_on_launch")
    private final String showOpenNewConversationOnLaunch;

    @SerializedName("show_reset_bot_subject_info")
    private final Boolean showResetBotSubjectInfo;

    @SerializedName("support_bot_search_web_and_pic_gen_switch")
    private final FeatureDetailWithSwitch supportSearchAndGen;

    @SerializedName("timestamp")
    @JsonAdapter(TimeTransformAdapter.class)
    private final long timestamp;

    @SerializedName("vlm_image_search_conf")
    private final VlmImageSearchConf vlmImageSearchConf;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (this.timestamp == r101.timestamp) goto L12;
        return false;
    L12:
        if (this.debug == r101.debug) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.modelList, r101.modelList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botLanguageList, r101.botLanguageList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.botReportReasonList, r101.botReportReasonList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageReportReasonList, r101.messageReportReasonList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.feedbackMeta, r101.feedbackMeta) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.feedbackPlaceholder, r101.feedbackPlaceholder) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.shareInfo, r101.shareInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.discardLink, r101.discardLink) == true) goto L39;
        return false;
    L39:
        if (this.saveChatHistoryPopupEnable == r101.saveChatHistoryPopupEnable) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.showOpenNewConversationOnLaunch, r101.showOpenNewConversationOnLaunch) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.immersiveModeConfig, r101.immersiveModeConfig) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.actionBarShowBotConfig, r101.actionBarShowBotConfig) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.highlightJump, r101.highlightJump) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.cocoSettingList, r101.cocoSettingList) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.cocoSettingRegisterEnable, r101.cocoSettingRegisterEnable) == true) goto L60;
        return false;
    L60:
        if (this.debugEntranceEnable == r101.debugEntranceEnable) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.enablePromptDetail, r101.enablePromptDetail) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.showResetBotSubjectInfo, r101.showResetBotSubjectInfo) == true) goto L69;
        return false;
    L69:
        if (this.enableRedBadgeOpt == r101.enableRedBadgeOpt) goto L72;
        return false;
    L72:
        if (this.appIconRedBadgeClosed == r101.appIconRedBadgeClosed) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.appIconRedBadge, r101.appIconRedBadge) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.bgImageConfig, r101.bgImageConfig) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.creationConfig, r101.creationConfig) == true) goto L84;
        return false;
    L84:
        if (this.createAvatarMaxUploadImgCnt == r101.createAvatarMaxUploadImgCnt) goto L87;
        return false;
    L87:
        if (this.createAvatarMinUploadImgCnt == r101.createAvatarMinUploadImgCnt) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.deepThinkingConfig, r101.deepThinkingConfig) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.vlmImageSearchConf, r101.vlmImageSearchConf) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.personalizedRecommend, r101.personalizedRecommend) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.inputWithSuggest, r101.inputWithSuggest) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.discoverTag, r101.discoverTag) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.supportSearchAndGen, r101.supportSearchAndGen) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.actionbarConfigurable, r101.actionbarConfigurable) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.appletThirdAuthSetting, r101.appletThirdAuthSetting) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.attach, r101.attach) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.attachFile, r101.attachFile) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.attachImgAlbum, r101.attachImgAlbum) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.attachImgCamera, r101.attachImgCamera) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.attachSug, r101.attachSug) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.attachmentArea, r101.attachmentArea) == true) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.previewImgCamera, r101.previewImgCamera) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.previewSug, r101.previewSug) == true) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.showBotLike, r101.showBotLike) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.showBotComment, r101.showBotComment) == true) goto L147;
        return false;
    L147:
        if (Intrinsics.areEqual(this.relatedVideo, r101.relatedVideo) == true) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.recordReplyMode, r101.recordReplyMode) == true) goto L153;
        return false;
    L153:
        if (Intrinsics.areEqual(this.defaultReplyModeMenu, r101.defaultReplyModeMenu) == true) goto L156;
        return false;
    L156:
        if (Intrinsics.areEqual(this.botCreateEnable, r101.botCreateEnable) == true) goto L159;
        return false;
    L159:
        if (Intrinsics.areEqual(this.defaultReplyModeMenuUseV3, r101.defaultReplyModeMenuUseV3) == true) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.defaultActiveModeMenu, r101.defaultActiveModeMenu) == true) goto L164;
        return false;
    L164:
        return true;
    }

    public final int hashCode() {
        long r100 = this.timestamp;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        int r102 = 1231;
        if (this.debug == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r101 + r103) * 31;
        List<ModelItem> r105 = this.modelList;
        int r106 = 0;
        if (r105 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r104 + r107) * 31;
        List<BotLanguage> r109 = this.botLanguageList;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        List<ReportReason> r112 = this.botReportReasonList;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        List<ReportReason> r115 = this.messageReportReasonList;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        List<FeedbackMeta> r118 = this.feedbackMeta;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.feedbackPlaceholder;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        shareInfo r124 = this.shareInfo;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.discardLink;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        if (this.saveChatHistoryPopupEnable == false) goto L41;
        int r130 = 1231;
    L42:
        int r131 = (r129 + r130) * 31;
        String r132 = this.showOpenNewConversationOnLaunch;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        ImmersConfig r135 = this.immersiveModeConfig;
        if (r135 != null) goto L49;
        int r136 = 0;
    L50:
        int r137 = (r134 + r136) * 31;
        ActionBarConfig r138 = this.actionBarShowBotConfig;
        if (r138 != null) goto L53;
        int r139 = 0;
    L54:
        int r140 = (r137 + r139) * 31;
        String r141 = this.highlightJump;
        if (r141 != null) goto L57;
        int r142 = 0;
    L58:
        int r143 = (r140 + r142) * 31;
        List<CocoSetting> r144 = this.cocoSettingList;
        if (r144 != null) goto L61;
        int r145 = 0;
    L62:
        int r146 = (r143 + r145) * 31;
        Boolean r147 = this.cocoSettingRegisterEnable;
        if (r147 != null) goto L65;
        int r148 = 0;
    L66:
        int r149 = (r146 + r148) * 31;
        if (this.debugEntranceEnable == false) goto L69;
        int r150 = 1231;
    L70:
        int r151 = (r149 + r150) * 31;
        Boolean r152 = this.enablePromptDetail;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        Boolean r155 = this.showResetBotSubjectInfo;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        if (this.enableRedBadgeOpt == false) goto L81;
        int r158 = 1231;
    L82:
        int r159 = (r157 + r158) * 31;
        if (this.appIconRedBadgeClosed == true) goto L86;
        r102 = 1237;
    L86:
        int r160 = (r159 + r102) * 31;
        FeatureDetail r161 = this.appIconRedBadge;
        if (r161 != null) goto L89;
        int r162 = 0;
    L90:
        int r163 = (r160 + r162) * 31;
        BgImageConfig r164 = this.bgImageConfig;
        if (r164 != null) goto L93;
        int r165 = 0;
    L94:
        int r166 = (r163 + r165) * 31;
        CreationConfig r167 = this.creationConfig;
        if (r167 != null) goto L97;
        int r168 = 0;
    L98:
        int r169 = (((((r166 + r168) * 31) + this.createAvatarMaxUploadImgCnt) * 31) + this.createAvatarMinUploadImgCnt) * 31;
        Map<String, String> r170 = this.extra;
        if (r170 != null) goto L101;
        int r171 = 0;
    L102:
        int r172 = (r169 + r171) * 31;
        DeepThinkingConfig r173 = this.deepThinkingConfig;
        if (r173 != null) goto L105;
        int r174 = 0;
    L106:
        int r175 = (r172 + r174) * 31;
        VlmImageSearchConf r176 = this.vlmImageSearchConf;
        if (r176 != null) goto L109;
        int r177 = 0;
    L110:
        int r178 = (r175 + r177) * 31;
        FeatureDetail r179 = this.personalizedRecommend;
        if (r179 != null) goto L113;
        int r180 = 0;
    L114:
        int r181 = (r178 + r180) * 31;
        FeatureDetail r182 = this.inputWithSuggest;
        if (r182 != null) goto L117;
        int r183 = 0;
    L118:
        int r184 = (r181 + r183) * 31;
        FeatureDetail r185 = this.discoverTag;
        if (r185 != null) goto L121;
        int r186 = 0;
    L122:
        int r187 = (r184 + r186) * 31;
        FeatureDetailWithSwitch r188 = this.supportSearchAndGen;
        if (r188 != null) goto L125;
        int r189 = 0;
    L126:
        int r190 = (r187 + r189) * 31;
        FeatureDetail r191 = this.actionbarConfigurable;
        if (r191 != null) goto L129;
        int r192 = 0;
    L130:
        int r193 = (r190 + r192) * 31;
        FeatureDetail r194 = this.appletThirdAuthSetting;
        if (r194 != null) goto L133;
        int r195 = 0;
    L134:
        int r196 = (r193 + r195) * 31;
        d0 r197 = this.attach;
        if (r197 != null) goto L137;
        int r198 = 0;
    L138:
        int r199 = (r196 + r198) * 31;
        FeatureDetail r200 = this.attachFile;
        if (r200 != null) goto L141;
        int r201 = 0;
    L142:
        int r202 = (r199 + r201) * 31;
        FeatureDetail r203 = this.attachImgAlbum;
        if (r203 != null) goto L145;
        int r204 = 0;
    L146:
        int r205 = (r202 + r204) * 31;
        FeatureDetail r206 = this.attachImgCamera;
        if (r206 != null) goto L149;
        int r207 = 0;
    L150:
        int r208 = (r205 + r207) * 31;
        FeatureDetail r209 = this.attachSug;
        if (r209 != null) goto L153;
        int r210 = 0;
    L154:
        int r211 = (r208 + r210) * 31;
        FeatureDetail r212 = this.attachmentArea;
        if (r212 != null) goto L157;
        int r213 = 0;
    L158:
        int r214 = (r211 + r213) * 31;
        FeatureDetail r215 = this.previewImgCamera;
        if (r215 != null) goto L161;
        int r216 = 0;
    L162:
        int r217 = (r214 + r216) * 31;
        FeatureDetail r218 = this.previewSug;
        if (r218 != null) goto L165;
        int r219 = 0;
    L166:
        int r220 = (r217 + r219) * 31;
        FeatureDetail r221 = this.showBotLike;
        if (r221 != null) goto L169;
        int r222 = 0;
    L170:
        int r223 = (r220 + r222) * 31;
        FeatureDetail r224 = this.showBotComment;
        if (r224 != null) goto L173;
        int r225 = 0;
    L174:
        int r226 = (r223 + r225) * 31;
        FeatureDetail r227 = this.relatedVideo;
        if (r227 != null) goto L177;
        int r228 = 0;
    L178:
        int r229 = (r226 + r228) * 31;
        FeatureDetail r230 = this.recordReplyMode;
        if (r230 != null) goto L181;
        int r231 = 0;
    L182:
        int r232 = (r229 + r231) * 31;
        FeatureDetail r233 = this.defaultReplyModeMenu;
        if (r233 != null) goto L185;
        int r234 = 0;
    L186:
        int r235 = (r232 + r234) * 31;
        FeatureDetail r236 = this.botCreateEnable;
        if (r236 != null) goto L189;
        int r237 = 0;
    L190:
        int r238 = (r235 + r237) * 31;
        FeatureDetail r239 = this.defaultReplyModeMenuUseV3;
        if (r239 != null) goto L193;
        int r240 = 0;
    L194:
        int r241 = (r238 + r240) * 31;
        FeatureDetail r242 = this.defaultActiveModeMenu;
        if (r242 == null) goto L199;
        r106 = r242.hashCode();
    L199:
        return r241 + r106;
    L193:
        r240 = r239.hashCode();
        goto L194
    L189:
        r237 = r236.hashCode();
        goto L190
    L185:
        r234 = r233.hashCode();
        goto L186
    L181:
        r231 = r230.hashCode();
        goto L182
    L177:
        r228 = r227.hashCode();
        goto L178
    L173:
        r225 = r224.hashCode();
        goto L174
    L169:
        r222 = r221.hashCode();
        goto L170
    L165:
        r219 = r218.hashCode();
        goto L166
    L161:
        r216 = r215.hashCode();
        goto L162
    L157:
        r213 = r212.hashCode();
        goto L158
    L153:
        r210 = r209.hashCode();
        goto L154
    L149:
        r207 = r206.hashCode();
        goto L150
    L145:
        r204 = r203.hashCode();
        goto L146
    L141:
        r201 = r200.hashCode();
        goto L142
    L137:
        r198 = r197.hashCode();
        goto L138
    L133:
        r195 = r194.hashCode();
        goto L134
    L129:
        r192 = r191.hashCode();
        goto L130
    L125:
        r189 = r188.hashCode();
        goto L126
    L121:
        r186 = r185.hashCode();
        goto L122
    L117:
        r183 = r182.hashCode();
        goto L118
    L113:
        r180 = r179.hashCode();
        goto L114
    L109:
        r177 = r176.hashCode();
        goto L110
    L105:
        r174 = r173.hashCode();
        goto L106
    L101:
        r171 = r170.hashCode();
        goto L102
    L97:
        r168 = r167.hashCode();
        goto L98
    L93:
        r165 = r164.hashCode();
        goto L94
    L89:
        r162 = r161.hashCode();
        goto L90
    L81:
        r158 = 1237;
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = 1237;
        goto L70
    L65:
        r148 = r147.hashCode();
        goto L66
    L61:
        r145 = r144.hashCode();
        goto L62
    L57:
        r142 = r141.hashCode();
        goto L58
    L53:
        r139 = r138.hashCode();
        goto L54
    L49:
        r136 = r135.hashCode();
        goto L50
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = 1237;
        goto L42
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r105.hashCode();
        goto L10
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "BasicLaunchInfo(timestamp=" + this.timestamp + ", debug=" + this.debug + ", modelList=" + this.modelList + ", botLanguageList=" + this.botLanguageList + ", botReportReasonList=" + this.botReportReasonList + ", messageReportReasonList=" + this.messageReportReasonList + ", feedbackMeta=" + this.feedbackMeta + ", feedbackPlaceholder=" + this.feedbackPlaceholder + ", shareInfo=" + this.shareInfo + ", discardLink=" + this.discardLink + ", saveChatHistoryPopupEnable=" + this.saveChatHistoryPopupEnable + ", showOpenNewConversationOnLaunch=" + this.showOpenNewConversationOnLaunch + ", immersiveModeConfig=" + this.immersiveModeConfig + ", actionBarShowBotConfig=" + this.actionBarShowBotConfig + ", highlightJump=" + this.highlightJump + ", cocoSettingList=" + this.cocoSettingList + ", cocoSettingRegisterEnable=" + this.cocoSettingRegisterEnable + ", debugEntranceEnable=" + this.debugEntranceEnable + ", enablePromptDetail=" + this.enablePromptDetail + ", showResetBotSubjectInfo=" + this.showResetBotSubjectInfo + ", enableRedBadgeOpt=" + this.enableRedBadgeOpt + ", appIconRedBadgeClosed=" + this.appIconRedBadgeClosed + ", appIconRedBadge=" + this.appIconRedBadge + ", bgImageConfig=" + this.bgImageConfig + ", creationConfig=" + this.creationConfig + ", createAvatarMaxUploadImgCnt=" + this.createAvatarMaxUploadImgCnt + ", createAvatarMinUploadImgCnt=" + this.createAvatarMinUploadImgCnt + ", extra=" + this.extra + ", deepThinkingConfig=" + this.deepThinkingConfig + ", vlmImageSearchConf=" + this.vlmImageSearchConf + ", personalizedRecommend=" + this.personalizedRecommend + ", inputWithSuggest=" + this.inputWithSuggest + ", discoverTag=" + this.discoverTag + ", supportSearchAndGen=" + this.supportSearchAndGen + ", actionbarConfigurable=" + this.actionbarConfigurable + ", appletThirdAuthSetting=" + this.appletThirdAuthSetting + ", attach=" + this.attach + ", attachFile=" + this.attachFile + ", attachImgAlbum=" + this.attachImgAlbum + ", attachImgCamera=" + this.attachImgCamera + ", attachSug=" + this.attachSug + ", attachmentArea=" + this.attachmentArea + ", previewImgCamera=" + this.previewImgCamera + ", previewSug=" + this.previewSug + ", showBotLike=" + this.showBotLike + ", showBotComment=" + this.showBotComment + ", relatedVideo=" + this.relatedVideo + ", recordReplyMode=" + this.recordReplyMode + ", defaultReplyModeMenu=" + this.defaultReplyModeMenu + ", botCreateEnable=" + this.botCreateEnable + ", defaultReplyModeMenuUseV3=" + this.defaultReplyModeMenuUseV3 + ", defaultActiveModeMenu=" + this.defaultActiveModeMenu + ')';
    }

    public e0() {
        this(System.currentTimeMillis(), false, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, null, Boolean.FALSE, false, false, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public final String A() {
        return this.discardLink;
    }

    public final FeatureDetail B() {
        return this.discoverTag;
    }

    public final Boolean C() {
        return this.enablePromptDetail;
    }

    public final boolean D() {
        return this.enableRedBadgeOpt;
    }

    public final Map<String, String> E() {
        return this.extra;
    }

    public final List<FeedbackMeta> F() {
        return this.feedbackMeta;
    }

    public final String G() {
        return this.feedbackPlaceholder;
    }

    public final String H() {
        return this.highlightJump;
    }

    public final ImmersConfig I() {
        return this.immersiveModeConfig;
    }

    public final FeatureDetail J() {
        return this.inputWithSuggest;
    }

    public final List<ReportReason> K() {
        return this.messageReportReasonList;
    }

    public final List<ModelItem> L() {
        return this.modelList;
    }

    public final FeatureDetail M() {
        return this.personalizedRecommend;
    }

    public final FeatureDetail N() {
        return this.previewImgCamera;
    }

    public final FeatureDetail O() {
        return this.previewSug;
    }

    public final FeatureDetail P() {
        return this.recordReplyMode;
    }

    public final FeatureDetail Q() {
        return this.relatedVideo;
    }

    public final boolean R() {
        return this.saveChatHistoryPopupEnable;
    }

    public final shareInfo S() {
        return this.shareInfo;
    }

    public final FeatureDetail T() {
        return this.showBotComment;
    }

    public final FeatureDetail U() {
        return this.showBotLike;
    }

    public final String V() {
        return this.showOpenNewConversationOnLaunch;
    }

    public final Boolean W() {
        return this.showResetBotSubjectInfo;
    }

    public final FeatureDetailWithSwitch X() {
        return this.supportSearchAndGen;
    }

    public final long Y() {
        return this.timestamp;
    }

    public final VlmImageSearchConf Z() {
        return this.vlmImageSearchConf;
    }

    public final ActionBarConfig a() {
        return this.actionBarShowBotConfig;
    }

    public final FeatureDetail b() {
        return this.actionbarConfigurable;
    }

    public final FeatureDetail c() {
        return this.appIconRedBadge;
    }

    public final boolean d() {
        return this.appIconRedBadgeClosed;
    }

    public final FeatureDetail e() {
        return this.appletThirdAuthSetting;
    }

    public final d0 f() {
        return this.attach;
    }

    public final FeatureDetail g() {
        return this.attachFile;
    }

    public final FeatureDetail h() {
        return this.attachImgAlbum;
    }

    public final FeatureDetail i() {
        return this.attachImgCamera;
    }

    public final FeatureDetail j() {
        return this.attachSug;
    }

    public final FeatureDetail k() {
        return this.attachmentArea;
    }

    public final BgImageConfig l() {
        return this.bgImageConfig;
    }

    public final FeatureDetail m() {
        return this.botCreateEnable;
    }

    public final List<BotLanguage> n() {
        return this.botLanguageList;
    }

    public final List<ReportReason> o() {
        return this.botReportReasonList;
    }

    public final List<CocoSetting> p() {
        return this.cocoSettingList;
    }

    public final Boolean q() {
        return this.cocoSettingRegisterEnable;
    }

    public final int r() {
        return this.createAvatarMaxUploadImgCnt;
    }

    public final int s() {
        return this.createAvatarMinUploadImgCnt;
    }

    public final CreationConfig t() {
        return this.creationConfig;
    }

    public final boolean u() {
        return this.debug;
    }

    public final boolean v() {
        return this.debugEntranceEnable;
    }

    public final DeepThinkingConfig w() {
        return this.deepThinkingConfig;
    }

    public final FeatureDetail x() {
        return this.defaultActiveModeMenu;
    }

    public final FeatureDetail y() {
        return this.defaultReplyModeMenu;
    }

    public final FeatureDetail z() {
        return this.defaultReplyModeMenuUseV3;
    }

    public e0(long r100, boolean r101, List<ModelItem> r102, List<BotLanguage> r103, List<ReportReason> r104, List<ReportReason> r110, List<FeedbackMeta> r111, String r112, shareInfo r113, String r114, boolean r115, String r116, ImmersConfig r117, ActionBarConfig r118, String r119, List<CocoSetting> r210, Boolean r211, boolean r212, Boolean r213, Boolean r214, boolean r215, boolean r216, FeatureDetail r217, BgImageConfig r218, CreationConfig r219, int r310, int r311, Map<String, String> r312, DeepThinkingConfig r313, VlmImageSearchConf r314, FeatureDetail r315, FeatureDetail r316, FeatureDetail r317, FeatureDetailWithSwitch r318, FeatureDetail r319, FeatureDetail r410, d0 r411, FeatureDetail r412, FeatureDetail r413, FeatureDetail r414, FeatureDetail r415, FeatureDetail r416, FeatureDetail r417, FeatureDetail r418, FeatureDetail r419, FeatureDetail r510, FeatureDetail r511, FeatureDetail r512, FeatureDetail r513, FeatureDetail r514, FeatureDetail r515, FeatureDetail r516) {
        this.timestamp = r100;
        this.debug = r101;
        this.modelList = r102;
        this.botLanguageList = r103;
        this.botReportReasonList = r104;
        this.messageReportReasonList = r110;
        this.feedbackMeta = r111;
        this.feedbackPlaceholder = r112;
        this.shareInfo = r113;
        this.discardLink = r114;
        this.saveChatHistoryPopupEnable = r115;
        this.showOpenNewConversationOnLaunch = r116;
        this.immersiveModeConfig = r117;
        this.actionBarShowBotConfig = r118;
        this.highlightJump = r119;
        this.cocoSettingList = r210;
        this.cocoSettingRegisterEnable = r211;
        this.debugEntranceEnable = r212;
        this.enablePromptDetail = r213;
        this.showResetBotSubjectInfo = r214;
        this.enableRedBadgeOpt = r215;
        this.appIconRedBadgeClosed = r216;
        this.appIconRedBadge = r217;
        this.bgImageConfig = r218;
        this.creationConfig = r219;
        this.createAvatarMaxUploadImgCnt = r310;
        this.createAvatarMinUploadImgCnt = r311;
        this.extra = r312;
        this.deepThinkingConfig = r313;
        this.vlmImageSearchConf = r314;
        this.personalizedRecommend = r315;
        this.inputWithSuggest = r316;
        this.discoverTag = r317;
        this.supportSearchAndGen = r318;
        this.actionbarConfigurable = r319;
        this.appletThirdAuthSetting = r410;
        this.attach = r411;
        this.attachFile = r412;
        this.attachImgAlbum = r413;
        this.attachImgCamera = r414;
        this.attachSug = r415;
        this.attachmentArea = r416;
        this.previewImgCamera = r417;
        this.previewSug = r418;
        this.showBotLike = r419;
        this.showBotComment = r510;
        this.relatedVideo = r511;
        this.recordReplyMode = r512;
        this.defaultReplyModeMenu = r513;
        this.botCreateEnable = r514;
        this.defaultReplyModeMenuUseV3 = r515;
        this.defaultActiveModeMenu = r516;
    }
}
