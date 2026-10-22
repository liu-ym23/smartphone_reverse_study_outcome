package com.ss.android.ainote;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.bmhome.chat.bean.SuggestActionType;
import com.ss.android.ainote.model.AINoteBlockStatus;
import com.ss.android.ainote.model.AINoteContentState;
import com.ss.android.ainote.model.AINoteCreateSource;
import com.ss.android.ainote.model.AINoteImageUploadState;
import com.ss.android.ainote.model.AINoteScene;
import com.ss.android.ainote.model.AINoteType;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.pb.entities.ImageCropType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class AINoteCacheStore {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f406468b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VFSFile f406469a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<xra.a> f406470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<j.a> f406471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<j.g> f406472c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<j.c> f406473d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<j.f> f406474e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<j.d> f406475f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<j.e> f406476g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f406477h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f406470a, r101.f406470a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f406471b, r101.f406471b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f406472c, r101.f406472c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f406473d, r101.f406473d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f406474e, r101.f406474e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f406475f, r101.f406475f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f406476g, r101.f406476g) == true) goto L30;
            return false;
        L30:
            if (this.f406477h == r101.f406477h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            return (((((((((((((this.f406470a.hashCode() * 31) + this.f406471b.hashCode()) * 31) + this.f406472c.hashCode()) * 31) + this.f406473d.hashCode()) * 31) + this.f406474e.hashCode()) * 31) + this.f406475f.hashCode()) * 31) + this.f406476g.hashCode()) * 31) + this.f406477h;
        }

        public final String toString() {
            return "CacheSnapshot(listSnapshot=" + this.f406470a + ", drafts=" + this.f406471b + ", pendingTextTasks=" + this.f406472c + ", pendingBatchCreateTasks=" + this.f406473d + ", pendingImageTasks=" + this.f406474e + ", pendingDeleteTasks=" + this.f406475f + ", pendingDownloadTasks=" + this.f406476g + ", recoverAttemptCount=" + this.f406477h + ')';
        }

        public a(List<xra.a> r100, List<j.a> r101, List<j.g> r102, List<j.c> r103, List<j.f> r104, List<j.d> r105, List<j.e> r106, int r107) {
            Intrinsics.checkNotNullParameter(r100, "listSnapshot");
            Intrinsics.checkNotNullParameter(r101, "drafts");
            Intrinsics.checkNotNullParameter(r102, "pendingTextTasks");
            Intrinsics.checkNotNullParameter(r103, "pendingBatchCreateTasks");
            Intrinsics.checkNotNullParameter(r104, "pendingImageTasks");
            Intrinsics.checkNotNullParameter(r105, "pendingDeleteTasks");
            Intrinsics.checkNotNullParameter(r106, "pendingDownloadTasks");
            this.f406470a = r100;
            this.f406471b = r101;
            this.f406472c = r102;
            this.f406473d = r103;
            this.f406474e = r104;
            this.f406475f = r105;
            this.f406476g = r106;
            this.f406477h = r107;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f406478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AINoteScene f406479b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f406478a, r101.f406478a) == true) goto L12;
            return false;
        L12:
            if (this.f406479b == r101.f406479b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f406478a.hashCode() * 31) + this.f406479b.hashCode();
        }

        public final String toString() {
            return "StoredRequestTarget(requestId=" + this.f406478a + ", scene=" + this.f406479b + ')';
        }

        public c(String r100, AINoteScene r101) {
            Intrinsics.checkNotNullParameter(r100, "requestId");
            Intrinsics.checkNotNullParameter(r101, "scene");
            this.f406478a = r100;
            this.f406479b = r101;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f406480a = null;

        static {
            int[] r100 = new int[AINoteScene.values().length];
            r100[AINoteScene.Meeting.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[AINoteScene.Record.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[AINoteScene.Hardware.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[AINoteScene.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f406480a = r100;
        }
    }

    static {
    }

    public final boolean b() {
        if (this.f406469a.exists() == false) goto L6;
        return true;
    L6:
        if (this.f406469a.mkdirs() == false) goto L8;
        return true;
    L8:
        int r100 = t.f407207a;
        t.b("AINoteCacheStore", "create cache dir failed: " + this.f406469a.getAbsolutePath());
        return false;
    }

    public AINoteCacheStore(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f406469a = VFSFiles.f444819b.i(r100.getFilesDir().getAbsolutePath() + "/ai-note-cache");
    }

    public static JSONArray A(List r100) {
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        xra.b r103 = (xra.b) r102.next();
        r101.put(new JSONObject().put("imageId", r103.f564919a).put("localUri", r103.f564920b).put("originLocalUri", r103.f564921c).put("uploadToken", r103.f564922d).put("remoteKey", r103.f564923e).put("thumbSource", z(r103.f564924f)).put("originSource", z(r103.f564925g)).put("uploadState", r103.f564926h.name()).put(DBDefinition.RETRY_COUNT, r103.f564927i).put("lastErrorMessage", r103.f564928j));
        goto L4
    L6:
        return r101;
    }

    public static JSONArray B(List r100) {
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        xra.a r103 = (xra.a) r102.next();
        JSONObject r104 = new JSONObject().put("cid", r103.f564896a).put(WsConstants.KEY_SESSION_ID, r103.f564897b);
        AINoteCreateSource r105 = r103.f564898c;
        if (r105 == null) goto L8;
        String r106 = r105.name();
    L9:
        r101.put(r104.put("noteSource", r106).put("inputRichText", H(r103.f564899d)).put("inputMarkdown", r103.f564900e).put("aiRichText", H(r103.f564901f)).put("aiMarkdown", r103.f564902g).put("noteType", r103.f564904i.name()).put("isMark", r103.f564904i.isMark()).put("version", r103.f564905j).put("clientTime", r103.f564906k).put("serverTime", r103.f564907l).put("contentState", r103.f564908m.name()).put("polishEnabled", r103.f564909n).put("deleted", r103.f564910o).put("createRelMeetingTime", r103.f564911p).put("createRelAudioTime", r103.f564912q).put("markId", r103.f564913r).put("audioLocationTime", r103.f564914s).put("aiContentAck", r103.f564915t).put("status", r103.f564916u.name()).put("images", A(r103.f564903h)));
        goto L4
    L8:
        r106 = null;
        goto L9
    L10:
        return r101;
    }

    public static JSONArray C(List r100) {
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        j.c r103 = (j.c) r102.next();
        JSONObject r104 = k(new JSONObject(), r103.f406795b, r103.f406796c).put("batchId", r103.f406794a);
        JSONArray r105 = new JSONArray();
        Iterator<T> r106 = r103.f406797d.iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        r105.put(((Number) r106.next()).longValue());
        goto L7
    L9:
        Unit r107 = Unit.INSTANCE;
        r101.put(r104.put("noteIds", r105).put("createdAtMs", r103.f406798e).put(DBDefinition.RETRY_COUNT, r103.f406799f));
        goto L4
    L10:
        return r101;
    }

    public static JSONArray D(List r100) {
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        j.d r103 = (j.d) r102.next();
        r101.put(k(new JSONObject(), r103.f406802c, r103.f406803d).put(DBDefinition.TASK_ID, r103.f406800a).put("noteId", r103.f406801b).put(WsConstants.KEY_SESSION_ID, r103.f406804e).put("version", r103.f406805f));
        goto L4
    L6:
        return r101;
    }

    public static JSONArray E(List r100) {
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        j.e r103 = (j.e) r102.next();
        r101.put(k(new JSONObject(), r103.f406807b, r103.f406808c).put("noteId", r103.f406806a).put("imageId", r103.f406809d).put("forOrigin", r103.f406811f).put("source", z(r103.f406810e)).put("nextAttemptAtMs", r103.f406812g).put(DBDefinition.RETRY_COUNT, r103.f406813h));
        goto L4
    L6:
        return r101;
    }

    public static JSONArray F(List r100) {
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        j.f r103 = (j.f) r102.next();
        r101.put(k(new JSONObject(), r103.f406815b, r103.f406816c).put("noteId", r103.f406814a).put("imageId", r103.f406817d).put("localUri", r103.f406818e).put("nextAttemptAtMs", r103.f406819f));
        goto L4
    L6:
        return r101;
    }

    public static JSONArray G(List r100) {
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        j.g r103 = (j.g) r102.next();
        r101.put(k(new JSONObject(), r103.f406822c, r103.f406823d).put(DBDefinition.TASK_ID, r103.f406820a).put("noteId", r103.f406821b).put("version", r103.f406824e).put("inputRichText", H(r103.f406825f)).put("inputMarkdown", r103.f406826g).put("isCreate", r103.f406827h));
        goto L4
    L6:
        return r101;
    }

    public static String H(RichText r100) {
        Object r101 = null;
        if (r100 == null) goto L19;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        Object r103 = Result.m9449constructorimpl(JSON.toJSONString(r100, new SerializerFeature[]{SerializerFeature.WriteClassName}));     // Catch: Throwable -> L6
    L8:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L12;
        t.c("AINoteCacheStore", "writeRichText failed", r104);
    L12:
        if (Result.m9455isFailureimpl(r103) == true) goto L16;
        r101 = r103;
    L16:
        return (String) r101;
    L6:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    L19:
        return null;
    }

    public static AINoteCreateSource h(String r100) {
        AINoteCreateSource.Companion.getClass();
        if (r100 == null) goto L5;
        String r101 = StringsKt.trim(r100).toString();
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(r101, "") == false) goto L11;
        return null;
    L11:
        if (Intrinsics.areEqual(r101, "INPUT") == true) goto L45;
        if (Intrinsics.areEqual(r101, AINoteCreateSource.INPUT.toEventValue()) == true) goto L45;
        if (Intrinsics.areEqual(r101, "HIGHLIGHT") == true) goto L52;
        if (Intrinsics.areEqual(r101, AINoteCreateSource.HIGHLIGHT.toEventValue()) == true) goto L52;
        if (Intrinsics.areEqual(r101, SuggestActionType.PHOTO) == true) goto L51;
        if (Intrinsics.areEqual(r101, AINoteCreateSource.PHOTO.toEventValue()) == true) goto L51;
        if (Intrinsics.areEqual(r101, "SUBTITLE_HIGHLIGHT") == true) goto L50;
        if (Intrinsics.areEqual(r101, AINoteCreateSource.SUBTITLE_HIGHLIGHT.toEventValue()) == true) goto L50;
        if (Intrinsics.areEqual(r101, "AI_VISION_HIGHLIGHT") == true) goto L49;
        if (Intrinsics.areEqual(r101, AINoteCreateSource.AI_VISION_HIGHLIGHT.toEventValue()) == true) goto L49;
        if (Intrinsics.areEqual(r101, "EMPTY_STATE") == true) goto L48;
        if (Intrinsics.areEqual(r101, AINoteCreateSource.EMPTY_STATE.toEventValue()) == true) goto L48;
        return null;
    L48:
        return AINoteCreateSource.EMPTY_STATE;
    L49:
        return AINoteCreateSource.AI_VISION_HIGHLIGHT;
    L50:
        return AINoteCreateSource.SUBTITLE_HIGHLIGHT;
    L51:
        return AINoteCreateSource.PHOTO;
    L52:
        return AINoteCreateSource.HIGHLIGHT;
    L45:
        return AINoteCreateSource.INPUT;
    L5:
        r101 = null;
        goto L6
    }

    public static s m(JSONObject r110) {
        ImageCropType r100 = null;
        if (r110 != null) goto L5;
        return null;
    L5:
        String r101 = f(r110, "imageKey");
        if (r101 != null) goto L8;
        return null;
    L8:
        String r102 = r110.optString("fsUnit");
        String r103 = f(r110, "crypto");
        if (r103 == null) goto L12;
        ByteString.Companion.getClass();
        ByteString r104 = ByteString.a.a(r103);
        if (r104 == null) goto L12;
    L13:
        ByteString r105 = r104;
        String r106 = r110.optString("cropType");
        ImageCropType r107 = ImageCropType.ORIGIN;
        ImageCropType[] r108 = ImageCropType.values();
        int r109 = r108.length;
        int r111 = 0;
    L14:
        if (r111 >= r109) goto L19;
        ImageCropType r112 = r108[r111];
        if (Intrinsics.areEqual(r112.name(), r106) == true) goto L17;
        r111 = r111 + 1;
        goto L14
    L17:
        r100 = r112;
    L19:
        if (r100 != null) goto L21;
        ImageCropType r113 = r107;
    L23:
        return new s(r101, r102, r105, r113, r110.optInt("width"), r110.optInt("height"), r110.optInt("exifOrientation"));
    L21:
        r113 = r100;
    L12:
        r104 = ByteString.EMPTY;
        goto L13
    }

    public static List n(JSONArray r110) {
        JSONArray r100 = r110;
        if (r100 == null) goto L5;
        ArrayList r101 = new ArrayList(r110.length());
        int r102 = r110.length();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L23;
        JSONObject r104 = r100.optJSONObject(r103);
        if (r104 != null) goto L11;
        int r111 = r102;
    L22:
        r103 = r103 + 1;
        r100 = r110;
        r102 = r111;
        goto L7
    L11:
        String r105 = r104.optString("imageId");
        String r106 = r104.optString("localUri");
        String r112 = r104.optString("originLocalUri");
        String r113 = f(r104, "uploadToken");
        String r114 = f(r104, "remoteKey");
        s r115 = m(r104.optJSONObject("thumbSource"));
        s r116 = m(r104.optJSONObject("originSource"));
        String r107 = r104.optString("uploadState");
        AINoteImageUploadState r108 = AINoteImageUploadState.LOCAL;
        AINoteImageUploadState[] r117 = AINoteImageUploadState.values();
        int r109 = r117.length;
        int r118 = 0;
    L12:
        if (r118 >= r109) goto L17;
        AINoteImageUploadState r119 = r117[r118];
        r111 = r102;
        if (Intrinsics.areEqual(r119.name(), r107) == true) goto L18;
        r118 = r118 + 1;
        r102 = r111;
    L18:
        if (r119 != null) goto L20;
        AINoteImageUploadState r120 = r108;
    L21:
        r101.add(new xra.b(r105, r106, r112, r113, r114, r115, r116, r120, r104.optInt(DBDefinition.RETRY_COUNT), f(r104, "lastErrorMessage")));
        goto L22
    L20:
        r120 = r119;
        goto L21
    L17:
        r111 = r102;
        r119 = null;
        goto L18
    L23:
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }

    public static RichText v(String r100) {
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L26;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        Object r103 = Result.m9449constructorimpl((RichText) JSON.parseObject(r100, RichText.class));     // Catch: Throwable -> L12
    L14:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L18;
        t.c("AINoteCacheStore", "readRichText failed", r104);
    L18:
        if (Result.m9455isFailureimpl(r103) == true) goto L22;
        r101 = r103;
    L22:
        return (RichText) r101;
    L12:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L26:
        return null;
    }

    public static JSONArray y(List r100) {
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L21;
        j.a r103 = (j.a) r102.next();
        JSONArray r104 = new JSONArray();
        Iterator<T> r105 = r103.C.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        r104.put((String) r105.next());
        goto L7
    L9:
        JSONObject r106 = k(new JSONObject(), r103.f406769b, r103.f406770c).put("noteId", r103.f406768a).put("cid", r103.f406771d).put(WsConstants.KEY_SESSION_ID, r103.f406772e);
        AINoteCreateSource r107 = r103.f406773f;
        String r108 = null;
        if (r107 == null) goto L12;
        String r109 = r107.name();
    L13:
        JSONObject r110 = r106.put("noteSource", r109).put("inputRichText", H(r103.f406790w)).put("inputMarkdown", r103.f406791x).put("committedInputRichText", H(r103.f406786s)).put("committedImages", A(r103.f406787t));
        JSONArray r111 = new JSONArray();
        Iterator<T> r112 = r103.f406788u.iterator();
    L15:
        if (r112.hasNext() == false) goto L17;
        r111.put((String) r112.next());
        goto L15
    L17:
        Unit r113 = Unit.INSTANCE;
        JSONObject r114 = r110.put("committedDeletedImageIds", r111).put("committedContentState", r103.f406789v.name()).put("aiRichText", H(r103.f406792y)).put("aiMarkdown", r103.f406793z).put("noteType", r103.f406774g.name()).put("isMark", r103.f406774g.isMark()).put("version", r103.f406775h).put("clientTime", r103.f406776i).put("serverTime", r103.f406777j).put("contentState", r103.f406778k.name()).put("polishEnabled", r103.f406779l).put("deleted", r103.f406780m).put("createRelMeetingTime", r103.f406781n).put("createRelAudioTime", r103.f406782o).put("createRelSubtitleTime", r103.f406782o).put("markId", r103.f406783p).put("audioLocationTime", r103.f406784q).put("aiContentAck", r103.f406785r).put("status", r103.A.name()).put("pendingCommit", r103.D).put("pendingDelete", r103.E);
        AINotePendingDeleteReason r115 = r103.F;
        if (r115 == null) goto L20;
        r108 = r115.name();
    L20:
        r101.put(r114.put("pendingDeleteReason", r108).put("firstNeedRequested", r103.G).put("pendingFirstNeedAfterCreate", r103.H).put("images", A(r103.B)).put("deletedImageIds", r104));
        goto L4
    L12:
        r109 = null;
        goto L13
    L21:
        return r101;
    }

    public static JSONObject z(s r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new JSONObject().put("imageKey", r100.f407200a).put("fsUnit", r100.f407201b).put("crypto", r100.f407202c.base64()).put("cropType", r100.f407203d.name()).put("width", r100.f407204e).put("height", r100.f407205f).put("exifOrientation", r100.f407206g);
    }

    public final List<String> e(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        if (b() == false) goto L5;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(this.f406469a.listFiles());     // Catch: Throwable -> L8
    L10:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L14;
        int r104 = t.f407207a;
        t.c("AINoteCacheStore", "list cache files failed, dir=" + this.f406469a.getAbsolutePath(), r103);
    L14:
        if (Result.m9455isFailureimpl(r102) == false) goto L16;
        r102 = null;
    L16:
        VFSFile[] r105 = (VFSFile[]) r102;
        if (r105 != null) goto L20;
        r105 = new VFSFile[0];
    L20:
        return SequencesKt.toList(SequencesKt.sorted(SequencesKt.distinct(SequencesKt.filter(SequencesKt.mapNotNull(SequencesKt.filter(ArraysKt.asSequence(r105), AINoteCacheStore$getCachedSessionKeys$1.INSTANCE), new AINoteCacheStore$getCachedSessionKeys$2(this, r100)), AINoteCacheStore$getCachedSessionKeys$3.INSTANCE))));
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L5:
        return CollectionsKt.emptyList();
    }

    public static void I(VFSFile r100, String r101) {
        Writer r102 = new OutputStreamWriter(VFSFiles.f444819b.s(r100.getVfsPath(), false), StandardCharsets.UTF_8);
        if ((r102 instanceof BufferedWriter) == false) goto L5;
        BufferedWriter r103 = (BufferedWriter) r102;
    L14:
        r103.write(r101);     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r103, null);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L5:
        r103 = new BufferedWriter(r102, 8192);
        goto L14
    }

    public static String d(String r100, AINoteScene r101) {
        StringBuilder r102 = new StringBuilder("u_");
        r102.append(URLEncoder.encode(r100, StandardCharsets.UTF_8.name()));
        r102.append('_');
        int r103 = d.f406480a[r101.ordinal()];
        if (r103 != 1) goto L5;
    L15:
        String r104 = "meeting_";
    L16:
        r102.append(r104);
        return r102.toString();
    L5:
        if (r103 != 2) goto L7;
        r104 = "record_";
        goto L16
    L7:
        if (r103 != 3) goto L9;
        r104 = "hardware_";
        goto L16
    L9:
        if (r103 == 4) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    public static String f(JSONObject r100, String r101) {
        if (r100.isNull(r101) == false) goto L5;
        return null;
    L5:
        String r102 = r100.optString(r101, "");
        Intrinsics.checkNotNull(r102);
        boolean r103 = false;
        if (r102.length() <= 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
    L13:
        if (r103 == true) goto L15;
        return null;
    L15:
        return r102;
    L11:
        if (Intrinsics.areEqual(r102, "null") == true) goto L13;
        r103 = true;
        goto L13
    L8:
        r104 = false;
        goto L9
    }

    public static AINoteContentState g(String r100, int r101) {
        if (Intrinsics.areEqual(r100, "ORIGINAL") == true) goto L22;
        if (r100 == null) goto L19;
        if (Intrinsics.areEqual(r100, "") == true) goto L19;
        AINoteContentState r102 = AINoteContentState.NO_NEED;
        AINoteContentState[] r103 = AINoteContentState.values();
        int r104 = r103.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L15;
        AINoteContentState r106 = r103[r105];
        if (Intrinsics.areEqual(r106.name(), r100) == true) goto L13;
        r105 = r105 + 1;
        goto L10
    L13:
        AINoteContentState r107 = r106;
    L16:
        if (r107 == null) goto L24;
        return r107;
    L24:
        return r102;
    L15:
        r107 = null;
    L19:
        return AINoteContentState.NO_NEED;
    L22:
        return AINoteContentState.NO_NEED;
    }

    public static AINoteType i(JSONObject r100, AINoteScene r101) {
        String r102 = f(r100, "noteType");
        int r103 = 0;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L21;
        AINoteType r105 = AINoteType.REGULAR;
        AINoteType[] r106 = AINoteType.values();
        int r107 = r106.length;
    L11:
        if (r103 >= r107) goto L16;
        AINoteType r108 = r106[r103];
        if (Intrinsics.areEqual(r108.name(), r102) == true) goto L17;
        r103 = r103 + 1;
    L17:
        if (r108 != null) goto L20;
        return r105;
    L20:
        return r108;
    L16:
        r108 = null;
        goto L17
    L21:
        AINoteType.a r109 = AINoteType.Companion;
        boolean r110 = r100.optBoolean("isMark");
        r109.getClass();
        return AINoteType.a.a(r110, r101);
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r104 = false;
        goto L9
    }

    public static List p(JSONArray r110, AINoteScene r111) {
        if (r110 == null) goto L5;
        ArrayList r100 = new ArrayList(r110.length());
        int r101 = r110.length();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L37;
        JSONObject r103 = r110.optJSONObject(r102);
        if (r103 == null) goto L36;
        c r104 = u(r103, r111);
        String r112 = f(r103, "batchId");
        if (r112 == null) goto L36;
        JSONArray r105 = r103.optJSONArray("noteIds");
        if (r105 == null) goto L29;
        List r106 = CollectionsKt.createListBuilder();
        int r113 = r105.length();
        int r114 = 0;
    L17:
        if (r114 >= r113) goto L19;
        r106.add(Long.valueOf(r105.optLong(r114)));
        r114 = r114 + 1;
        goto L17
    L19:
        List r107 = CollectionsKt.build(r106);
        ArrayList r108 = new ArrayList();
        Iterator r109 = r107.iterator();
    L21:
        if (r109.hasNext() == false) goto L28;
        Object r115 = r109.next();
        if (((Number) r115).longValue() <= 0) goto L25;
        boolean r116 = true;
    L26:
        if (r116 == false) goto L21;
        r108.add(r115);
        goto L21
    L25:
        r116 = false;
        goto L26
    L28:
        List r117 = CollectionsKt.distinct(r108);
    L30:
        if (r117 != null) goto L32;
        r117 = CollectionsKt.emptyList();
    L32:
        List r118 = r117;
        if (r118.isEmpty() == true) goto L36;
        r100.add(new j.c(r112, r104.f406478a, r104.f406479b, r118, r103.optLong("createdAtMs"), r103.optInt(DBDefinition.RETRY_COUNT)));
        goto L36
    L29:
        r117 = null;
    L36:
        r102 = r102 + 1;
        goto L7
    L37:
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public static List q(JSONArray r110, AINoteScene r210) {
        if (r110 == null) goto L5;
        ArrayList r100 = new ArrayList(r110.length());
        int r101 = r110.length();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L13;
        JSONObject r103 = r110.optJSONObject(r102);
        if (r103 == null) goto L12;
        c r104 = u(r103, r210);
        r100.add(new j.d(r103.optLong(DBDefinition.TASK_ID), r103.optLong("noteId"), r104.f406478a, r104.f406479b, r103.optLong(WsConstants.KEY_SESSION_ID), r103.optLong("version")));
    L12:
        r102 = r102 + 1;
        goto L7
    L13:
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public static List r(JSONArray r110, AINoteScene r210) {
        if (r110 == null) goto L5;
        ArrayList r100 = new ArrayList(r110.length());
        int r101 = r110.length();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L16;
        JSONObject r103 = r110.optJSONObject(r102);
        if (r103 == null) goto L15;
        c r104 = u(r103, r210);
        long r105 = r103.optLong("noteId");
        String r111 = r104.f406478a;
        AINoteScene r112 = r104.f406479b;
        String r113 = r103.optString("imageId");
        s r114 = m(r103.optJSONObject("source"));
        if (r114 == null) goto L15;
        r100.add(new j.e(r105, r111, r112, r113, r114, r103.optBoolean("forOrigin"), r103.optLong("nextAttemptAtMs"), r103.optInt(DBDefinition.RETRY_COUNT)));
    L15:
        r102 = r102 + 1;
        goto L7
    L16:
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public static List s(JSONArray r110, AINoteScene r111) {
        if (r110 == null) goto L5;
        ArrayList r100 = new ArrayList(r110.length());
        int r101 = r110.length();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L13;
        JSONObject r103 = r110.optJSONObject(r102);
        if (r103 == null) goto L12;
        c r104 = u(r103, r111);
        r100.add(new j.f(r103.optLong("noteId"), r104.f406478a, r104.f406479b, r103.optString("imageId"), r103.optString("localUri"), r103.optLong("nextAttemptAtMs")));
    L12:
        r102 = r102 + 1;
        goto L7
    L13:
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public static c u(JSONObject r100, AINoteScene r101) {
        String r102 = f(r100, "requestId");
        if (r102 == null) goto L5;
        String r103 = f(r100, "scene");
        if (r103 == null) goto L20;
        AINoteScene[] r104 = AINoteScene.values();
        int r105 = r104.length;
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L14;
        AINoteScene r107 = r104[r106];
        if (Intrinsics.areEqual(r107.name(), r103) == true) goto L15;
        r106 = r106 + 1;
    L15:
        if (r107 != null) goto L17;
        r107 = r101;
    L17:
        if (r107 == null) goto L20;
        r101 = r107;
        goto L20
    L14:
        r107 = null;
    L20:
        return new c(r102, r101);
    L5:
        return new c("", r101);
    }

    public static JSONObject k(JSONObject r100, String r101, AINoteScene r102) {
        return r100.put("requestId", r101).put("scene", r102.name());
    }

    public static List l(JSONArray r510, int r511, AINoteScene r512) {
        JSONArray r100 = r510;
        if (r100 == null) goto L5;
        ArrayList r101 = new ArrayList(r510.length());
        int r102 = r510.length();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L107;
        JSONObject r104 = r100.optJSONObject(r103);
        if (r104 != null) goto L11;
        int r513 = r102;
    L106:
        r103 = r103 + 1;
        r100 = r510;
        r102 = r513;
        goto L7
    L11:
        c r105 = u(r104, r512);
        RichText r410 = v(f(r104, "inputRichText"));
        RichText r310 = v(f(r104, "committedInputRichText"));
        JSONArray r106 = r104.optJSONArray("committedImages");
        List r107 = n(r106);
        RichText r411 = v(f(r104, "aiRichText"));
        JSONArray r110 = r104.optJSONArray("deletedImageIds");
        boolean r111 = true;
        if (r110 == null) goto L26;
        List r112 = CollectionsKt.createListBuilder();
        int r113 = r110.length();
        int r114 = 0;
    L14:
        if (r114 >= r113) goto L25;
        String r108 = r110.optString(r114);
        if (r108 != null) goto L18;
    L21:
        boolean r115 = true;
    L22:
        if (r115 == true) goto L24;
        r112.add(r108);
    L24:
        r114 = r114 + 1;
        goto L14
    L18:
        if (StringsKt.isBlank(r108) == true) goto L21;
        r115 = false;
        goto L22
    L25:
        List r109 = CollectionsKt.build(r112);
    L27:
        if (r109 != null) goto L29;
        r109 = CollectionsKt.emptyList();
    L29:
        List r412 = r109;
        JSONArray r116 = r104.optJSONArray("committedDeletedImageIds");
        if (r116 == null) goto L44;
        List r117 = CollectionsKt.createListBuilder();
        int r118 = r116.length();
        int r119 = 0;
    L32:
        if (r119 >= r118) goto L43;
        String r120 = r116.optString(r119);
        if (r120 != null) goto L36;
    L39:
        boolean r121 = true;
    L40:
        if (r121 == true) goto L42;
        r117.add(r120);
    L42:
        r119 = r119 + 1;
        goto L32
    L36:
        if (StringsKt.isBlank(r120) == true) goto L39;
        r121 = false;
        goto L40
    L43:
        List r122 = CollectionsKt.build(r117);
    L45:
        if (r122 != null) goto L47;
        r122 = CollectionsKt.emptyList();
    L47:
        AINoteContentState r210 = g(r104.optString("contentState"), r511);
        long r123 = r104.optLong("noteId");
        String r124 = r105.f406478a;
        AINoteScene r125 = r105.f406479b;
        long r126 = r104.optLong("cid");
        long r211 = r104.optLong(WsConstants.KEY_SESSION_ID);
        AINoteCreateSource r212 = h(f(r104, "noteSource"));
        AINoteScene r127 = r105.f406479b;
        if (r127 != AINoteScene.UNKNOWN) goto L51;
        r111 = false;
    L51:
        if (r111 == true) goto L54;
        r127 = null;
    L54:
        if (r127 != null) goto L56;
        r127 = r512;
    L56:
        AINoteType r128 = i(r104, r127);
        long r213 = r104.optLong("version");
        long r214 = r104.optLong("clientTime");
        long r215 = r104.optLong("serverTime");
        boolean r311 = r104.optBoolean("polishEnabled");
        boolean r312 = r104.optBoolean("deleted");
        long r313 = r104.optLong("createRelMeetingTime");
        long r129 = r104.optLong("createRelAudioTime");
        if (r129 > 0) goto L60;
        r129 = r104.optLong("createRelSubtitleTime");
    L60:
        long r314 = r129;
        String r315 = f(r104, "markId");
        long r316 = r104.optLong("audioLocationTime");
        boolean r413 = r104.optBoolean("aiContentAck");
        if (r106 != null) goto L63;
        List r130 = n(r104.optJSONArray("images"));
    L64:
        if (r116 != null) goto L66;
        List r131 = r412;
    L67:
        String r132 = f(r104, "committedContentState");
        if (r132 == null) goto L80;
        AINoteContentState[] r133 = AINoteContentState.values();
        int r134 = r133.length;
        r513 = r102;
        int r135 = 0;
    L70:
        if (r135 >= r134) goto L75;
        AINoteContentState r216 = r133[r135];
        if (Intrinsics.areEqual(r216.name(), r132) == true) goto L76;
        r135 = r135 + 1;
    L76:
        if (r216 != null) goto L78;
        r216 = r210;
    L78:
        if (r216 == null) goto L81;
        AINoteContentState r136 = r216;
    L82:
        String r137 = f(r104, "inputMarkdown");
        String r414 = f(r104, "aiMarkdown");
        String r138 = r104.optString("status");
        AINoteBlockStatus r139 = AINoteBlockStatus.NORMAL;
        AINoteBlockStatus[] r140 = AINoteBlockStatus.values();
        int r141 = r140.length;
        int r142 = 0;
    L83:
        if (r142 >= r141) goto L88;
        AINoteBlockStatus r415 = r140[r142];
        int r416 = r141;
        if (Intrinsics.areEqual(r415.name(), r138) == true) goto L89;
        r142 = r142 + 1;
        r141 = r416;
    L89:
        if (r415 != null) goto L91;
        r415 = r139;
    L91:
        List r417 = n(r104.optJSONArray("images"));
        boolean r418 = r104.optBoolean("pendingCommit");
        boolean r419 = r104.optBoolean("pendingDelete");
        String r143 = f(r104, "pendingDeleteReason");
        if (r143 == null) goto L104;
        AINotePendingDeleteReason r144 = AINotePendingDeleteReason.AUTO_EMPTY;
        AINotePendingDeleteReason[] r145 = AINotePendingDeleteReason.values();
        int r146 = r145.length;
        int r147 = 0;
    L94:
        if (r147 >= r146) goto L99;
        AINotePendingDeleteReason r217 = r145[r147];
        AINotePendingDeleteReason r514 = r144;
        if (Intrinsics.areEqual(r217.name(), r143) == true) goto L97;
        r147 = r147 + 1;
        r144 = r514;
        goto L94
    L97:
        AINotePendingDeleteReason r148 = r217;
    L100:
        if (r148 != null) goto L102;
        AINotePendingDeleteReason r149 = r514;
    L103:
        AINotePendingDeleteReason r515 = r149;
    L105:
        List r317 = r130;
        List r318 = r131;
        AINoteContentState r420 = r136;
        r101.add(new j.a(r123, r124, r125, r126, r211, r212, r128, r213, r214, r215, r210, r311, r312, r313, r314, r315, r316, r413, r310, r317, r318, r420, r410, r137, r411, r414, r415, r417, r412, r418, r419, r515, r104.optBoolean("firstNeedRequested"), r104.optBoolean("pendingFirstNeedAfterCreate")));
        goto L106
    L102:
        r149 = r148;
        goto L103
    L99:
        r514 = r144;
        r148 = null;
        goto L100
    L104:
        r515 = null;
        goto L105
    L88:
        r415 = null;
    L81:
        r136 = r210;
        goto L82
    L75:
        r216 = null;
        goto L76
    L80:
        r513 = r102;
        goto L81
    L66:
        r131 = r122;
        goto L67
    L63:
        r130 = r107;
        goto L64
    L44:
        r122 = null;
        goto L45
    L26:
        r109 = null;
        goto L27
    L107:
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }

    public static List o(JSONArray r310, int r410, AINoteScene r411) {
        JSONArray r100 = r310;
        if (r100 == null) goto L5;
        ArrayList r101 = new ArrayList(r310.length());
        int r102 = r310.length();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L26;
        JSONObject r104 = r100.optJSONObject(r103);
        if (r104 == null) goto L25;
        AINoteType r110 = i(r104, r411);
        long r105 = r104.optLong("cid");
        long r111 = r104.optLong(WsConstants.KEY_SESSION_ID);
        AINoteCreateSource r112 = h(f(r104, "noteSource"));
        RichText r113 = v(f(r104, "inputRichText"));
        String r114 = f(r104, "inputMarkdown");
        RichText r115 = v(f(r104, "aiRichText"));
        String r116 = f(r104, "aiMarkdown");
        List r117 = n(r104.optJSONArray("images"));
        long r118 = r104.optLong("version");
        long r210 = r104.optLong("clientTime");
        long r211 = r104.optLong("serverTime");
        AINoteContentState r212 = g(r104.optString("contentState"), r410);
        boolean r213 = r104.optBoolean("polishEnabled");
        boolean r214 = r104.optBoolean("deleted");
        long r215 = r104.optLong("createRelMeetingTime");
        long r311 = r104.optLong("createRelAudioTime");
        if (r311 > 0) goto L15;
        r311 = r104.optLong("createRelSubtitleTime");
    L15:
        String r312 = f(r104, "markId");
        long r313 = r104.optLong("audioLocationTime");
        boolean r314 = r104.optBoolean("aiContentAck");
        String r106 = r104.optString("status");
        AINoteBlockStatus r107 = AINoteBlockStatus.NORMAL;
        AINoteBlockStatus[] r108 = AINoteBlockStatus.values();
        int r109 = r108.length;
        int r119 = 0;
    L16:
        if (r119 >= r109) goto L21;
        AINoteBlockStatus r315 = r108[r119];
        AINoteBlockStatus[] r316 = r108;
        if (Intrinsics.areEqual(r315.name(), r106) == true) goto L22;
        r119 = r119 + 1;
        r108 = r316;
    L22:
        if (r315 != null) goto L24;
        r315 = r107;
    L24:
        r101.add(n.d(new xra.a(r105, r111, r112, r113, r114, r115, r116, r117, r110, r118, r210, r211, r212, r213, r214, r215, r311, r312, r313, r314, r315, false)));
        goto L25
    L21:
        r315 = null;
    L25:
        r103 = r103 + 1;
        r100 = r310;
        r102 = r102;
        goto L7
    L26:
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }

    public static List t(JSONArray r210, int r211, AINoteScene r212) {
        if (r210 == null) goto L5;
        ArrayList r100 = new ArrayList(r210.length());
        int r101 = r210.length();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L24;
        JSONObject r103 = r210.optJSONObject(r102);
        if (r103 == null) goto L23;
        c r104 = u(r103, r212);
        RichText r110 = v(f(r103, "inputRichText"));
        if (r110 == null) goto L23;
        boolean r111 = r103.optBoolean("isCreate");
        long r105 = r103.optLong(DBDefinition.TASK_ID);
        long r112 = r103.optLong("noteId");
        String r113 = r104.f406478a;
        AINoteScene r114 = r104.f406479b;
        if (r103.has("version") == false) goto L18;
        long r213 = r103.optLong("version");
    L22:
        long r115 = r213;
        r100.add(new j.g(r105, r112, r113, r114, r115, r110, f(r103, "inputMarkdown"), r111));
        goto L23
    L18:
        if (r211 >= 2) goto L21;
        if (r111 == false) goto L21;
        r213 = 1;
    L21:
        r213 = 0;
    L23:
        r102 = r102 + 1;
        goto L7
    L24:
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public final void a(String r100, String r101, AINoteScene r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "requestId");
        Intrinsics.checkNotNullParameter(r102, "scene");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        c(r100, r101, r102).delete();     // Catch: Throwable -> L5
        x(r100, r101, r102).delete();     // Catch: Throwable -> L5
        int r104 = t.f407207a;     // Catch: Throwable -> L5
        t.d("AINoteCacheStore", "clear success, userId=" + r100 + ", requestId=" + r101 + ", scene=" + r102);     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L13;
        int r107 = t.f407207a;
        t.c("AINoteCacheStore", "clear failed, userId=" + r100 + ", requestId=" + r101 + ", scene=" + r102 + ", target=" + c(r100, r101, r102).getAbsolutePath(), r106);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final VFSFile c(String r100, String r101, AINoteScene r102) {
        String r103 = d(r100, r102);
        return VFSFiles.f444819b.i(this.f406469a.getAbsolutePath() + '/' + r103 + URLEncoder.encode(r101, StandardCharsets.UTF_8.name()) + InvRouter.FLOW_SUFFIX);
    }

    public final a w(String r210, String r211, AINoteScene r212) {
        Intrinsics.checkNotNullParameter(r210, "userId");
        Intrinsics.checkNotNullParameter(r211, "requestId");
        Intrinsics.checkNotNullParameter(r212, "scene");
        VFSFile r100 = c(r210, r211, r212);
        if (r100.exists() == true) goto L6;
        int r101 = t.f407207a;
        t.d("AINoteCacheStore", "restore skip, cache missing, userId=" + r210 + ", requestId=" + r211 + ", scene=" + r212);
        return null;
    L6:
        int r102 = t.f407207a;
        t.d("AINoteCacheStore", "restore start, userId=" + r210 + ", requestId=" + r211 + ", scene=" + r212 + ", path=" + r100.getAbsolutePath());
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L22
        Reader r110 = new InputStreamReader(VFSFiles.f444819b.j(r100), StandardCharsets.UTF_8);     // Catch: Throwable -> L22
        if ((r110 instanceof BufferedReader) == false) goto L11;
        BufferedReader r111 = (BufferedReader) r110;     // Catch: Throwable -> L22
    L38:
        String r112 = TextStreamsKt.readText(r111);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r111, null);     // Catch: Throwable -> L22
        JSONObject r104 = new JSONObject(r112);     // Catch: Throwable -> L22
        int r105 = r104.optInt("schemaVersion", 1);     // Catch: Throwable -> L22
        Object r106 = Result.m9449constructorimpl(new a(o(r104.optJSONArray("listSnapshot"), r105, r212), l(r104.optJSONArray("drafts"), r105, r212), t(r104.optJSONArray("pendingTextTasks"), r105, r212), p(r104.optJSONArray("pendingBatchCreateTasks"), r212), s(r104.optJSONArray("pendingImageTasks"), r212), q(r104.optJSONArray("pendingDeleteTasks"), r212), r(r104.optJSONArray("pendingDownloadTasks"), r212), r104.optInt("recoverAttemptCount", 0)));     // Catch: Throwable -> L22
    L24:
        Object r107 = r106;
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L32;
        int r113 = t.f407207a;
        t.c("AINoteCacheStore", "restore failed, userId=" + r210 + ", requestId=" + r211 + ", scene=" + r212 + ", path=" + r100.getAbsolutePath(), r108);
        Result.m9449constructorimpl(Boolean.valueOf(r100.delete()));     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L32:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L36;
        r107 = new a(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), 0);
    L36:
        return (a) r107;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r111, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L11:
        r111 = new BufferedReader(r110, 8192);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public final VFSFile x(String r100, String r101, AINoteScene r102) {
        String r103 = d(r100, r102);
        return VFSFiles.f444819b.i(this.f406469a.getAbsolutePath() + '/' + r103 + URLEncoder.encode(r101, StandardCharsets.UTF_8.name()) + ".json.tmp");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String] */
    public final void j(String r310, String r311, AINoteScene r312, List<xra.a> r313, List<j.a> r314, List<j.g> r315, List<j.c> r316, List<j.f> r317, List<j.d> r318, List<j.e> r319, boolean r410, int r411) {
        String r100 = "userId";
        Intrinsics.checkNotNullParameter(r310, "userId");
        String r101 = "requestId";
        Intrinsics.checkNotNullParameter(r311, "requestId");
        Intrinsics.checkNotNullParameter(r312, "scene");
        Intrinsics.checkNotNullParameter(r313, "listSnapshot");
        Intrinsics.checkNotNullParameter(r314, "drafts");
        Intrinsics.checkNotNullParameter(r315, "pendingTextTasks");
        Intrinsics.checkNotNullParameter(r316, "pendingBatchCreateTasks");
        Intrinsics.checkNotNullParameter(r317, "pendingImageTasks");
        Intrinsics.checkNotNullParameter(r318, "pendingDeleteTasks");
        Intrinsics.checkNotNullParameter(r319, "pendingDownloadTasks");
        String r102 = "recoverAttemptCount";
        String r103 = "schemaVersion";
        if (r313.isEmpty() == true) goto L5;
    L58:
        ?? r104 = r411;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L91
        if (b() == true) goto L62;
        AINoteScene r105 = r312;
        String r106 = ", scene=";
        r102 = ", requestId=";
        String r107 = "AINoteCacheStore";
    L80:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L81
        ?? r109 = r107;
        Object r111 = r105;
        String r112 = r106;
    L95:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r108);
        if (r113 == null) goto L116;
        int r114 = t.f407207a;
        t.c(r109, "persist failed, userId=" + r310 + r102 + r311 + r112 + r111 + ", target=" + c(r310, r311, r312).getAbsolutePath(), r113);
        return;
    L116:
        return;
    L62:
        JSONObject r115 = new JSONObject().put("schemaVersion", 10).put("userId", r310).put("requestId", r311).put("scene", r312.name()).put("listSnapshot", B(r313)).put("drafts", y(r314)).put("pendingTextTasks", G(r315)).put("pendingBatchCreateTasks", C(r316)).put("pendingImageTasks", F(r317)).put("pendingDeleteTasks", D(r318)).put("pendingDownloadTasks", E(r319)).put("recoverAttemptCount", r411);     // Catch: Throwable -> L91
        VFSFile r116 = c(r310, r311, r312);     // Catch: Throwable -> L91
        VFSFile r117 = x(r310, r311, r312);     // Catch: Throwable -> L91
        I(r117, r115.toString());     // Catch: Throwable -> L91
        if (r116.exists() == false) goto L70;
        if (r116.delete() == true) goto L70;
        throw new IllegalStateException("delete old cache file failed: " + r116.getAbsolutePath());     // Catch: Throwable -> L91
    L70:
        if (r117.renameTo(r116) == false) goto L90;
        int r118 = t.f407207a;     // Catch: Throwable -> L91
        StringBuilder r119 = new StringBuilder("persist success, userId=");     // Catch: Throwable -> L91
        r119.append(r310);     // Catch: Throwable -> L91
        r102 = ", requestId=";
        r119.append(r102);     // Catch: Throwable -> L87
        r119.append(r311);     // Catch: Throwable -> L87
        r119.append(", scene=");     // Catch: Throwable -> L85
        AINoteScene r120 = r312;
        String r121 = ", scene=";
        r119.append(r120);     // Catch: Throwable -> L83
        r119.append(", path=");     // Catch: Throwable -> L83
        r119.append(r116.getAbsolutePath());     // Catch: Throwable -> L83
        String r122 = "AINoteCacheStore";
        t.d(r122, r119.toString());     // Catch: Throwable -> L81
        r107 = r122;
        r105 = r120;
        r106 = r121;
    L83:
        th = th;
        AINoteScene r123 = r120;
        String r124 = r121;
    L93:
        r104 = "AINoteCacheStore";
        Object r125 = r123;
        String r126 = r124;
    L94:
        Result.Companion r127 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r109 = r104;
        r111 = r125;
        r112 = r126;
    L85:
        th = th;
        r123 = r312;
        r124 = ", scene=";
    L87:
        th = th;
        r123 = r312;
        r124 = ", scene=";
        goto L93
    L90:
        throw new IllegalStateException("rename cache file failed: " + r117.getAbsolutePath());     // Catch: Throwable -> L81
    L81:
        th = th;
        r125 = r100;
        r126 = r101;
    L91:
        th = th;
        r123 = r312;
        r124 = ", scene=";
        r102 = ", requestId=";
        goto L93
    L5:
        if (r314.isEmpty() == false) goto L58;
        if (r315.isEmpty() == false) goto L58;
        if (r316.isEmpty() == false) goto L58;
        if (r317.isEmpty() == false) goto L58;
        if (r318.isEmpty() == false) goto L58;
        if (r319.isEmpty() == false) goto L58;
        if (r410 == false) goto L102;
        a(r310, r311, r312);
        return;
    L102:
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L51
        if (b() == true) goto L22;
        AINoteScene r129 = r312;
        String r130 = ", scene=";
        r102 = ", requestId=";
        r103 = "AINoteCacheStore";
    L40:
        Object r131 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
        String r132 = r130;
        Object r133 = r129;
    L54:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r131);
        if (r134 == null) goto L115;
        int r135 = t.f407207a;
        t.c(r103, "persist empty snapshot failed, userId=" + r310 + r102 + r311 + r132 + r133 + ", target=" + c(r310, r311, r312).getAbsolutePath(), r134);
        return;
    L115:
        return;
    L22:
        JSONObject r136 = new JSONObject().put("schemaVersion", 10).put("userId", r310).put("requestId", r311).put("scene", r312.name()).put("listSnapshot", new JSONArray()).put("drafts", new JSONArray()).put("pendingTextTasks", new JSONArray()).put("pendingBatchCreateTasks", new JSONArray()).put("pendingImageTasks", new JSONArray()).put("pendingDeleteTasks", new JSONArray()).put("pendingDownloadTasks", new JSONArray()).put("recoverAttemptCount", r411);     // Catch: Throwable -> L51
        VFSFile r137 = c(r310, r311, r312);     // Catch: Throwable -> L51
        VFSFile r138 = x(r310, r311, r312);     // Catch: Throwable -> L51
        I(r138, r136.toString());     // Catch: Throwable -> L51
        if (r137.exists() == false) goto L30;
        if (r137.delete() == true) goto L30;
        throw new IllegalStateException("delete old cache file failed: " + r137.getAbsolutePath());     // Catch: Throwable -> L51
    L30:
        if (r138.renameTo(r137) == false) goto L50;
        int r139 = t.f407207a;     // Catch: Throwable -> L51
        StringBuilder r140 = new StringBuilder("persist empty snapshot, userId=");     // Catch: Throwable -> L51
        r140.append(r310);     // Catch: Throwable -> L51
        r102 = ", requestId=";
        r140.append(r102);     // Catch: Throwable -> L47
        r140.append(r311);     // Catch: Throwable -> L47
        String r141 = ", scene=";
        r140.append(r141);     // Catch: Throwable -> L45
        AINoteScene r142 = r312;
        r140.append(r142);     // Catch: Throwable -> L43
        r140.append(", path=");     // Catch: Throwable -> L43
        r140.append(r137.getAbsolutePath());     // Catch: Throwable -> L43
        r103 = "AINoteCacheStore";
        t.d(r103, r140.toString());     // Catch: Throwable -> L41
        r130 = r141;
        r129 = r142;
    L43:
        th = th;
    L44:
        r103 = "AINoteCacheStore";
        String r143 = r141;
        Object r144 = r142;
    L53:
        Result.Companion r145 = Result.Companion;
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r132 = r143;
        r133 = r144;
    L45:
        th = th;
        r142 = r312;
    L47:
        th = th;
        r142 = r312;
        r141 = ", scene=";
        goto L44
    L50:
        throw new IllegalStateException("rename cache file failed: " + r138.getAbsolutePath());     // Catch: Throwable -> L41
    L41:
        th = th;
        r143 = r100;
        r144 = r101;
    L51:
        th = th;
        r142 = r312;
        r141 = ", scene=";
        r102 = ", requestId=";
        goto L44
    }
}
