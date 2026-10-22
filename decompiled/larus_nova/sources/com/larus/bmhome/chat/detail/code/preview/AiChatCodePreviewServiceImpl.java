package com.larus.bmhome.chat.detail.code.preview;

import com.larus.bmhome.code.IAiChatCodePreviewService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/preview/AiChatCodePreviewServiceImpl;", "Lcom/larus/bmhome/code/IAiChatCodePreviewService;", "<init>", "()V", "getCodeForPreviewByCodeId", "", "codeId", "getLanguageForPreviewByCodeId", "showCodePreviewWeb", "", "isSuccess", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiChatCodePreviewServiceImpl implements IAiChatCodePreviewService {
    public AiChatCodePreviewServiceImpl() {
    }

    @Override // com.larus.bmhome.code.IAiChatCodePreviewService
    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "codeId");
        Lazy r101 = i.f302790a;
        if (r100 == null) goto L11;
        i.a r102 = (i.a) ((Map) i.f302791b.getValue()).get(r100);
        if (r102 != null) goto L13;
        j r103 = (j) ((Map) i.f302790a.getValue()).get(r100);
        if (r103 == null) goto L11;
        return r103.getCode();
    L13:
        return r102.f302792a;
    L11:
        return null;
    }

    @Override // com.larus.bmhome.code.IAiChatCodePreviewService
    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "codeId");
        Lazy r101 = i.f302790a;
        if (r100 == null) goto L11;
        i.a r102 = (i.a) ((Map) i.f302791b.getValue()).get(r100);
        if (r102 != null) goto L13;
        j r103 = (j) ((Map) i.f302790a.getValue()).get(r100);
        if (r103 == null) goto L11;
        return r103.getLanguage();
    L13:
        return r102.f302793b;
    L11:
        return null;
    }

    @Override // com.larus.bmhome.code.IAiChatCodePreviewService
    public final boolean a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "codeId");
        Lazy r102 = i.f302790a;
        if (r100 == null) goto L26;
        j r103 = (j) ((Map) i.f302790a.getValue()).get(r100);
        if (r103 == null) goto L11;
        if (r101 == false) goto L9;
        CodePreviewStatus r104 = CodePreviewStatus.SUCCESS;
    L10:
        r103.cw(r104);
    L23:
        return true;
    L9:
        r104 = CodePreviewStatus.FAIL;
        goto L10
    L11:
        m r105 = m.f302800a;
        if (r101 == false) goto L14;
        CodePreviewStatus r106 = CodePreviewStatus.SUCCESS;
    L15:
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "codeId");
        Intrinsics.checkNotNullParameter(r106, "status");
        m.a r107 = m.f302801b;
        if (r107 != null) goto L19;
    L20:
        boolean r108 = false;
    L22:
        if (r108 == true) goto L23;
        return false;
    L19:
        if (Intrinsics.areEqual(r107.f302805b, r100) == false) goto L20;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r107.f302809f = r106;
        r108 = true;
        goto L22
    L14:
        r106 = CodePreviewStatus.FAIL;
        goto L15
    L26:
        return false;
    }
}
