package com.larus.office.card.urlpreview;

import android.net.Uri;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.ArtifactStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.FileBlock;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h2 f361915a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f361916b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<Integer> f361917c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Integer> f361918d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<Integer> f361919e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<Integer> f361920f = null;

    public h2() {
    }

    static {
        f361915a = new h2();
        f361916b = SetsKt.setOf(new Integer[]{9, 10, 12, 14, 17});
        Set<Integer> r100 = SetsKt.setOf(new Integer[]{9, 10, 12});
        f361917c = r100;
        f361918d = SetsKt.plus(r100, 14);
        ArtifactStatus r101 = ArtifactStatus.GENERATED;
        ArtifactStatus r102 = ArtifactStatus.DELETED;
        f361919e = SetsKt.setOf(new Integer[]{Integer.valueOf(ArtifactStatus.GENERATING.getValue()), Integer.valueOf(r101.getValue()), Integer.valueOf(r102.getValue())});
        f361920f = SetsKt.setOf(new Integer[]{Integer.valueOf(r101.getValue()), Integer.valueOf(r102.getValue())});
    }

    public static boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        Uri r103 = (Uri) r102;
        if (r103 != null) goto L14;
        return false;
    L14:
        if (StringsKt.equals(r103.getScheme(), "http", true) == false) goto L16;
    L17:
        String r104 = r103.getHost();
        if (r104 != null) goto L20;
    L23:
        boolean r105 = true;
    L24:
        if (r105 == true) goto L30;
        return true;
    L30:
        return false;
    L20:
        if (StringsKt.isBlank(r104) == true) goto L23;
        r105 = false;
        goto L24
    L16:
        if (StringsKt.equals(r103.getScheme(), "https", true) == true) goto L17;
        return false;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static boolean d(ArtifactBlock r100) {
        Intrinsics.checkNotNullParameter(r100, "artifact");
        Intrinsics.checkNotNullParameter(r100, "artifact");
        Integer r101 = r100.getResourceType();
        if (r101 != null) goto L6;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L19;
    L20:
        return true;
    L19:
        if (CollectionsKt.contains(f361920f, r100.getStatus()) == true) goto L20;
        return false;
    L6:
        if (r101.intValue() != 0) goto L16;
        String r103 = r100.getResourceId();
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L16;
        r102 = true;
        goto L17
    L10:
        if (StringsKt.isBlank(r103) == true) goto L13;
        r104 = false;
        goto L14
    }

    public static String e(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        String r101 = r100.getMessageId();
        String r102 = null;
        if (r101 != null) goto L5;
    L9:
        String r103 = r100.getLocalMessageId();
        if (r103 != null) goto L12;
    L14:
        if (r102 != null) goto L17;
        return r100.getConversationId() + '_' + r100.getServerIndex() + '_' + r100.getLocalIndex() + '_' + r100.getCreateTime();
    L17:
        return r102;
    L12:
        if ((!StringsKt.isBlank(r103)) == false) goto L14;
        r102 = r103;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L9;
        return r101;
    }

    public static Integer f(ArtifactBlock r100) {
        Intrinsics.checkNotNullParameter(r100, "artifact");
        Integer r101 = r100.getResourceType();
        Integer r102 = j(r100);
        if (r102 != null) goto L6;
        r102 = r100.getSubResourceType();
    L6:
        return g(r101, r102);
    }

    public static ArtifactBlock h(Block r210) {
        Intrinsics.checkNotNullParameter(r210, "block");
        BlockContent r100 = r210.getContent();
        if (r100 == null) goto L7;
        ArtifactBlock r101 = r100.getDocBlock();
        if (r101 == null) goto L7;
        return r101;
    L7:
        BlockContent r102 = r210.getContent();
        if (r102 == null) goto L25;
        FileBlock r103 = r102.getFileBlock();
        if (r103 != null) goto L13;
        return null;
    L13:
        if (StringsKt.equals(r103.type, "html", true) == true) goto L15;
        return null;
    L15:
        String r104 = r103.uri;
        if (r104 != null) goto L18;
        return null;
    L18:
        if ((!StringsKt.isBlank(r104)) == false) goto L20;
        String r105 = r104;
    L21:
        if (r105 != null) goto L24;
        return null;
    L24:
        return new ArtifactBlock(r105, null, null, null, null, null, null, r103.name, null, null, 0, Integer.valueOf(ArtifactStatus.GENERATED.getValue()), null, null, 13182, null);
    L20:
        r105 = null;
        goto L21
    L25:
        return null;
    }

    public static String i(ArtifactBlock r100) {
        Intrinsics.checkNotNullParameter(r100, "artifact");
        String r101 = r100.getResourceId();
        if (r101 != null) goto L5;
    L76:
        return null;
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L76;
        Integer r102 = r100.getResourceType();
        if (r102 != null) goto L14;
    L16:
        if (r102 != null) goto L19;
    L20:
        if (r102 != null) goto L23;
    L25:
        if (r102 != null) goto L28;
    L30:
        if (r102 != null) goto L33;
    L35:
        if (r102 != null) goto L38;
    L47:
        if (r102 != null) goto L50;
        return null;
    L50:
        if (r102.intValue() != 0) goto L78;
        int r103 = a.f361821a;
        if ((!StringsKt.isBlank(r101)) == true) goto L55;
        r101 = null;
    L55:
        if (r101 == null) goto L87;
        Uri r104 = a.c();
        if (r104 == null) goto L79;
        Uri.Builder r105 = r104.buildUpon();
        if (r105 == null) goto L80;
        Uri.Builder r106 = r105.appendPath("drive");
        if (r106 == null) goto L81;
        Uri.Builder r107 = r106.appendPath("file");
        if (r107 == null) goto L82;
        Uri.Builder r108 = r107.appendPath("ABCDEFGHIJKLMMOPQRSTUVWXYZ");
        if (r108 == null) goto L83;
        Uri.Builder r109 = r108.appendQueryParameter("uri", r101);
        if (r109 == null) goto L84;
        Uri r110 = r109.build();
        if (r110 != null) goto L72;
        return null;
    L72:
        return r110.toString();
    L84:
        return null;
    L83:
        return null;
    L82:
        return null;
    L81:
        return null;
    L80:
        return null;
    L79:
        return null;
    L87:
        return null;
    L78:
        return null;
    L38:
        if (r102.intValue() != 17) goto L47;
        int r111 = a.f361821a;
        if ((!StringsKt.isBlank(r101)) == true) goto L43;
        r101 = null;
    L43:
        if (r101 != null) goto L46;
        return null;
    L46:
        return a.a("drive/file", r101);
    L33:
        if (r102.intValue() != 14) goto L35;
        String r112 = "wiki";
    L75:
        return a.a(r112, r101);
    L28:
        if (r102.intValue() != 12) goto L30;
        r112 = "sheets";
        goto L75
    L23:
        if (r102.intValue() != 11) goto L25;
    L73:
        r112 = DocumentType.DOCX_NAME;
        goto L75
    L19:
        if (r102.intValue() == 10) goto L73;
    L14:
        if (r102.intValue() != 9) goto L16;
        r112 = "slides";
        goto L75
    }

    public static Integer j(ArtifactBlock r100) {
        Intrinsics.checkNotNullParameter(r100, "artifact");
        Integer r101 = r100.getResourceType();
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.intValue() == 14) goto L10;
        return null;
    L10:
        return r100.getSubResourceType();
    }

    public static String a(Block r100, ArtifactBlock r110) {
        String r101 = r100.getBlockId();
        String r102 = null;
        if (r101 != null) goto L5;
    L9:
        String r103 = r110.getArtifactMetaId();
        if (r103 != null) goto L12;
    L14:
        if (r102 != null) goto L17;
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(new Object[]{r110.getResourceType(), r110.getResourceId(), r110.getArtifactVersionId(), r110.getResourceVersion(), r110.getTitle()}), ":", null, null, 0, null, null, 62, null);
    L17:
        return r102;
    L12:
        if ((!StringsKt.isBlank(r103)) == false) goto L14;
        r102 = r103;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L9;
        return r101;
    }

    public static Integer g(Integer r100, Integer r101) {
        if (r100 == null) goto L22;
        if (r100.intValue() != 14) goto L22;
        if (r101 != null) goto L9;
    L11:
        if (r101 != null) goto L14;
    L16:
        if (r101 != null) goto L19;
    L28:
        return null;
    L19:
        if (r101.intValue() != 3) goto L28;
        return 9;
    L14:
        if (r101.intValue() != 2) goto L16;
        return 12;
    L9:
        if (r101.intValue() != 1) goto L11;
        return 10;
    L22:
        if (CollectionsKt.contains(f361917c, r100) == true) goto L33;
        if (r100 == null) goto L28;
        if (r100.intValue() != 17) goto L28;
        return r100;
    L33:
        return r100;
    }

    public static r b(Message r100, Block r101, ArtifactBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "block");
        Intrinsics.checkNotNullParameter(r102, "artifact");
        return new r(e(r100), a(r101, r102));
    }

    public static boolean k(ArtifactBlock r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "artifact");
        if (vn9.a.a(r100) == false) goto L5;
        return false;
    L5:
        Integer r103 = r100.getResourceType();
        if (r103 != null) goto L9;
    L11:
        if (r103 == null) goto L21;
        if (r103.intValue() != 17) goto L21;
        if (r101 == false) goto L28;
        if (r102 == true) goto L18;
        return false;
    L18:
        if (d(r100) == false) goto L30;
    L25:
        return true;
    L30:
        return false;
    L28:
        return false;
    L21:
        if (CollectionsKt.contains(f361917c, r103) == false) goto L31;
        if (r101 == true) goto L24;
        return false;
    L24:
        if (CollectionsKt.contains(f361919e, r100.getStatus()) == true) goto L25;
        return false;
    L31:
        return false;
    L9:
        if (r103.intValue() != 14) goto L11;
        return d(r100);
    }
}
