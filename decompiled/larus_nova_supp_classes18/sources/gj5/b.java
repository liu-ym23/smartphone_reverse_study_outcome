package gj5;

import com.ss.android.lark.security.compliance.api.model.filepolicy.CheckPriority;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityOperate;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.Deprecated;
import yh5.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    void a(@EntityOperate String r1, FileBizDomain r2, int r3, String r4, Long r5, String r6, String r7, CheckPriority r8, a r9);

    void b(FileBizDomain r1, String r2, String r3, String r4, Integer r5, FileBizDomain r6);

    @Deprecated(message = "PermissionSDK")
    void c(@EntityOperate String r1, FileBizDomain r2, int r3, String r4);

    @Deprecated(message = "PermissionSDK.asyncValidate")
    void d(@EntityOperate String r1, FileBizDomain r2, int r3, String r4, Long r5, s55.c r6);

    c e(@EntityOperate String r1, FileBizDomain r2, int r3, String r4, String r5, String r6, Integer r7, boolean r8, FileBizDomain r9, String r10, @EntityType String r11);

    void f(@EntityOperate String r1, FileBizDomain r2, int r3, String r4, Long r5, String r6, String r7, CheckPriority r8, String r9, Long r10, Long r11, Long r12, k r13);

    @Deprecated(message = "PermissionSDK.validate")
    c g(@EntityOperate String r1, FileBizDomain r2, int r3, String r4);
}
