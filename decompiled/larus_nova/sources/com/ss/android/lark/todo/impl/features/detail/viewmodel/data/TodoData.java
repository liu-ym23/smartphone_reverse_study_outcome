package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.lark.pb.basic.v1.RichContent;
import com.bytedance.lark.pb.todo.v1.ContainerTaskFieldAssoc;
import com.bytedance.lark.pb.todo.v1.Progress;
import com.bytedance.lark.pb.todo.v1.SimpleTodo;
import com.bytedance.lark.pb.todo.v1.TaskDependentRef;
import com.bytedance.lark.pb.todo.v1.TaskFieldValue;
import com.bytedance.lark.pb.todo.v1.TaskMode;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoAttachment;
import com.bytedance.lark.pb.todo.v1.TodoFollower;
import com.bytedance.lark.pb.todo.v1.TodoOrigin;
import com.bytedance.lark.pb.todo.v1.TodoReminder;
import com.bytedance.lark.pb.todo.v1.TodoSource;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.todo.impl.features.center.v3.entity.TodoSceneType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010à\u0001\u001a\u00030á\u00012\u0007\u0010â\u0001\u001a\u00020\u0002J\u0007\u0010ã\u0001\u001a\u00020\u0000J\u0011\u0010ä\u0001\u001a\u00030á\u00012\u0007\u0010â\u0001\u001a\u00020\u0000J\u0014\u0010å\u0001\u001a\u00030á\u00012\n\u0010æ\u0001\u001a\u0005\u0018\u00010ç\u0001J\t\u0010è\u0001\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u00020\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001a\u0010\u001d\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001a\u0010/\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\"\"\u0004\b@\u0010$R \u0010A\u001a\b\u0012\u0004\u0012\u00020B0&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010)\"\u0004\bD\u0010+R\u001a\u0010E\u001a\u00020FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00102\"\u0004\bM\u00104R\u001a\u0010N\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00102\"\u0004\bP\u00104R\u001e\u0010Q\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u0010\n\u0002\u0010V\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010W\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\f\"\u0004\bX\u0010\u000eR\u001a\u0010Y\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\"\"\u0004\b[\u0010$R \u0010\\\u001a\b\u0012\u0004\u0012\u00020]0&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010)\"\u0004\b_\u0010+R\u001c\u0010`\u001a\u0004\u0018\u00010aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001a\u0010f\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u00102\"\u0004\bh\u00104R\u001a\u0010i\u001a\u00020jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010l\"\u0004\bq\u0010nR\u001c\u0010r\u001a\u0004\u0018\u00010sX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001c\u0010x\u001a\u0004\u0018\u00010yX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001b\u0010~\u001a\u00020 X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\"\"\u0005\b\u0080\u0001\u0010$R\u001d\u0010\u0081\u0001\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\"\"\u0005\b\u0083\u0001\u0010$R\"\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001d\u0010\u008a\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\f\"\u0005\b\u008c\u0001\u0010\u000eR\u001f\u0010\u008d\u0001\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\"\"\u0005\b\u008f\u0001\u0010$R-\u0010\u0090\u0001\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0005\u0012\u00030\u0092\u00010\u0091\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R \u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R1\u0010\u009d\u0001\u001a\u0014\u0012\u0004\u0012\u00020 0\u009e\u0001j\t\u0012\u0004\u0012\u00020 `\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R3\u0010¤\u0001\u001a\u0016\u0012\u0005\u0012\u00030¥\u00010\u009e\u0001j\n\u0012\u0005\u0012\u00030¥\u0001`\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0001\u0010¡\u0001\"\u0006\b§\u0001\u0010£\u0001R3\u0010¨\u0001\u001a\u0016\u0012\u0005\u0012\u00030¥\u00010\u009e\u0001j\n\u0012\u0005\u0012\u00030¥\u0001`\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010¡\u0001\"\u0006\bª\u0001\u0010£\u0001R3\u0010«\u0001\u001a\u0016\u0012\u0005\u0012\u00030¥\u00010\u009e\u0001j\n\u0012\u0005\u0012\u00030¥\u0001`\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010¡\u0001\"\u0006\b\u00ad\u0001\u0010£\u0001R-\u0010®\u0001\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0005\u0012\u00030°\u00010¯\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R3\u0010µ\u0001\u001a\u0016\u0012\u0005\u0012\u00030¶\u00010\u009e\u0001j\n\u0012\u0005\u0012\u00030¶\u0001`\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b·\u0001\u0010¡\u0001\"\u0006\b¸\u0001\u0010£\u0001R\u001d\u0010¹\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010\f\"\u0005\bº\u0001\u0010\u000eR3\u0010»\u0001\u001a\u0016\u0012\u0005\u0012\u00030¼\u00010\u009e\u0001j\n\u0012\u0005\u0012\u00030¼\u0001`\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b½\u0001\u0010¡\u0001\"\u0006\b¾\u0001\u0010£\u0001R,\u0010¿\u0001\u001a\u000f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00020¯\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÀ\u0001\u0010²\u0001\"\u0006\bÁ\u0001\u0010´\u0001R\u001d\u0010Â\u0001\u001a\u00020\u000bX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÂ\u0001\u0010\f\"\u0005\bÃ\u0001\u0010\u000eR\u001d\u0010Ä\u0001\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÅ\u0001\u0010\"\"\u0005\bÆ\u0001\u0010$R\u001d\u0010Ç\u0001\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÈ\u0001\u0010\"\"\u0005\bÉ\u0001\u0010$R\u001d\u0010Ê\u0001\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bË\u0001\u0010\"\"\u0005\bÌ\u0001\u0010$R\u001d\u0010Í\u0001\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÎ\u0001\u0010\"\"\u0005\bÏ\u0001\u0010$R\u001d\u0010Ð\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u0010\f\"\u0005\bÒ\u0001\u0010\u000eR\u001d\u0010Ó\u0001\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÔ\u0001\u0010\"\"\u0005\bÕ\u0001\u0010$R\u001d\u0010Ö\u0001\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b×\u0001\u0010\"\"\u0005\bØ\u0001\u0010$R\u001d\u0010Ù\u0001\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÚ\u0001\u0010\"\"\u0005\bÛ\u0001\u0010$R3\u0010Ü\u0001\u001a\u0016\u0012\u0005\u0012\u00030Ý\u00010\u009e\u0001j\n\u0012\u0005\u0012\u00030Ý\u0001`\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÞ\u0001\u0010¡\u0001\"\u0006\bß\u0001\u0010£\u0001¨\u0006é\u0001"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoData;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/BaseData;", "Lcom/bytedance/lark/pb/todo/v1/Todo;", "Ljava/io/Serializable;", "pbData", "<init>", "(Lcom/bytedance/lark/pb/todo/v1/Todo;)V", "getPbData", "()Lcom/bytedance/lark/pb/todo/v1/Todo;", "setPbData", "isCreateTodo", "", "()Z", "setCreateTodo", "(Z)V", "isShouldFastCreate", "setShouldFastCreate", "isShouldUseDraft", "setShouldUseDraft", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "Lcom/ss/android/lark/todo/impl/features/center/v3/entity/TodoSceneType;", "getSceneType", "()Lcom/ss/android/lark/todo/impl/features/center/v3/entity/TodoSceneType;", "setSceneType", "(Lcom/ss/android/lark/todo/impl/features/center/v3/entity/TodoSceneType;)V", "isCreateFromMessage", "setCreateFromMessage", "isCreateFromMultiMessage", "setCreateFromMultiMessage", "isInFastCreate", "setInFastCreate", "guid", "", "getGuid", "()Ljava/lang/String;", "setGuid", "(Ljava/lang/String;)V", "assignees", "", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoAssigneeData;", "getAssignees", "()Ljava/util/List;", "setAssignees", "(Ljava/util/List;)V", "referResourceId", "getReferResourceId", "setReferResourceId", "completedMilliTime", "", "getCompletedMilliTime", "()J", "setCompletedMilliTime", "(J)V", "deletedMilliTime", "getDeletedMilliTime", "setDeletedMilliTime", "source", "Lcom/bytedance/lark/pb/todo/v1/TodoSource;", "getSource", "()Lcom/bytedance/lark/pb/todo/v1/TodoSource;", "setSource", "(Lcom/bytedance/lark/pb/todo/v1/TodoSource;)V", "creatorId", "getCreatorId", "setCreatorId", "followers", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoFollowerData;", "getFollowers", "setFollowers", "selfPermissionData", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoItemPermissionData;", "getSelfPermissionData", "()Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoItemPermissionData;", "setSelfPermissionData", "(Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoItemPermissionData;)V", "dueTime", "getDueTime", "setDueTime", "startMilliTime", "getStartMilliTime", "setStartMilliTime", "displayCompletedMilliTime", "getDisplayCompletedMilliTime", "()Ljava/lang/Long;", "setDisplayCompletedMilliTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isAllDay", "setAllDay", "dueTimeZone", "getDueTimeZone", "setDueTimeZone", "reminders", "Lcom/bytedance/lark/pb/todo/v1/TodoReminder;", "getReminders", "setReminders", "creator", "Lcom/bytedance/lark/pb/todo/v1/TodoUser;", "getCreator", "()Lcom/bytedance/lark/pb/todo/v1/TodoUser;", "setCreator", "(Lcom/bytedance/lark/pb/todo/v1/TodoUser;)V", "createMilliTime", "getCreateMilliTime", "setCreateMilliTime", "richSummary", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoRichContent;", "getRichSummary", "()Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoRichContent;", "setRichSummary", "(Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoRichContent;)V", "richDescription", "getRichDescription", "setRichDescription", "progress", "Lcom/bytedance/lark/pb/todo/v1/Progress;", "getProgress", "()Lcom/bytedance/lark/pb/todo/v1/Progress;", "setProgress", "(Lcom/bytedance/lark/pb/todo/v1/Progress;)V", PlayerResolution.SDKKEY.ORIGIN, "Lcom/bytedance/lark/pb/todo/v1/TodoOrigin;", "getOrigin", "()Lcom/bytedance/lark/pb/todo/v1/TodoOrigin;", "setOrigin", "(Lcom/bytedance/lark/pb/todo/v1/TodoOrigin;)V", "rrule", "getRrule", "setRrule", "parentGuid", "getParentGuid", "setParentGuid", "parentSummary", "Lcom/bytedance/lark/pb/basic/v1/RichContent;", "getParentSummary", "()Lcom/bytedance/lark/pb/basic/v1/RichContent;", "setParentSummary", "(Lcom/bytedance/lark/pb/basic/v1/RichContent;)V", "summaryNeedTodBeUpdate", "getSummaryNeedTodBeUpdate", "setSummaryNeedTodBeUpdate", "ancestorGuid", "getAncestorGuid", "setAncestorGuid", "ancestors", "", "Lcom/bytedance/lark/pb/todo/v1/SimpleTodo;", "getAncestors", "()Ljava/util/Map;", "setAncestors", "(Ljava/util/Map;)V", "mode", "Lcom/bytedance/lark/pb/todo/v1/TaskMode;", "getMode", "()Lcom/bytedance/lark/pb/todo/v1/TaskMode;", "setMode", "(Lcom/bytedance/lark/pb/todo/v1/TaskMode;)V", "taskListGuids", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTaskListGuids", "()Ljava/util/ArrayList;", "setTaskListGuids", "(Ljava/util/ArrayList;)V", "uploadingAttachments", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoAttachmentData;", "getUploadingAttachments", "setUploadingAttachments", "deletedAttachments", "getDeletedAttachments", "setDeletedAttachments", "attachments", "getAttachments", "setAttachments", "customFieldValues", "Ljava/util/HashMap;", "Lcom/bytedance/lark/pb/todo/v1/TaskFieldValue;", "getCustomFieldValues", "()Ljava/util/HashMap;", "setCustomFieldValues", "(Ljava/util/HashMap;)V", "containerFieldAssociations", "Lcom/bytedance/lark/pb/todo/v1/ContainerTaskFieldAssoc;", "getContainerFieldAssociations", "setContainerFieldAssociations", "isMileStone", "setMileStone", "dependentRefs", "Lcom/bytedance/lark/pb/todo/v1/TaskDependentRef;", "getDependentRefs", "setDependentRefs", "taskDependents", "getTaskDependents", "setTaskDependents", "isValid", "setValid", "trackEventName", "getTrackEventName", "setTrackEventName", "rank", "getRank", "setRank", "containerGuid", "getContainerGuid", "setContainerGuid", "sectionGuid", "getSectionGuid", "setSectionGuid", "createSuccess", "getCreateSuccess", "setCreateSuccess", "ownedRank", "getOwnedRank", "setOwnedRank", "ownedContainerGuid", "getOwnedContainerGuid", "setOwnedContainerGuid", "ownedSectionGuid", "getOwnedSectionGuid", "setOwnedSectionGuid", "ownedSections", "Lcom/bytedance/lark/pb/todo/v1/TaskSection;", "getOwnedSections", "setOwnedSections", "updateFromPbData", "", IOfflineExtraParser.ParserType.TODO, "copy", "updateFromTodoData", "updateFromSimpleTodo", "simpleTodo", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/SimpleSubTodoData;", "parseToPb", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoData implements a<Todo>, Serializable {
    private String ancestorGuid;
    private Map<String, SimpleTodo> ancestors;
    private List<TodoAssigneeData> assignees;
    private ArrayList<TodoAttachmentData> attachments;
    private long completedMilliTime;
    private ArrayList<ContainerTaskFieldAssoc> containerFieldAssociations;
    private String containerGuid;
    private long createMilliTime;
    private boolean createSuccess;
    private TodoUser creator;
    private String creatorId;
    private HashMap<String, TaskFieldValue> customFieldValues;
    private ArrayList<TodoAttachmentData> deletedAttachments;
    private long deletedMilliTime;
    private ArrayList<TaskDependentRef> dependentRefs;
    private Long displayCompletedMilliTime;
    private long dueTime;
    private String dueTimeZone;
    private List<TodoFollowerData> followers;
    private String guid;
    private boolean isAllDay;
    private boolean isCreateFromMessage;
    private boolean isCreateFromMultiMessage;
    private boolean isCreateTodo;
    private boolean isInFastCreate;
    private boolean isMileStone;
    private boolean isShouldFastCreate;
    private boolean isShouldUseDraft;
    private boolean isValid;
    private TaskMode mode;
    private TodoOrigin origin;
    private String ownedContainerGuid;
    private String ownedRank;
    private String ownedSectionGuid;
    private ArrayList<TaskSection> ownedSections;
    private String parentGuid;
    private RichContent parentSummary;
    private Todo pbData;
    private Progress progress;
    private String rank;
    private String referResourceId;
    private List<TodoReminder> reminders;
    private TodoRichContent richDescription;
    private TodoRichContent richSummary;
    private String rrule;
    private TodoSceneType sceneType;
    private String sectionGuid;
    private TodoItemPermissionData selfPermissionData;
    private TodoSource source;
    private long startMilliTime;
    private boolean summaryNeedTodBeUpdate;
    private HashMap<String, Todo> taskDependents;
    private ArrayList<String> taskListGuids;
    private String trackEventName;
    private ArrayList<TodoAttachmentData> uploadingAttachments;

    public final TodoData copy() {
        TodoData r100 = new TodoData(getPbData());
        r100.setPbData(getPbData());
        r100.richSummary = this.richSummary;
        r100.richDescription = this.richDescription;
        r100.assignees = this.assignees;
        r100.completedMilliTime = this.completedMilliTime;
        r100.referResourceId = this.referResourceId;
        r100.source = this.source;
        r100.origin = this.origin;
        r100.creatorId = this.creatorId;
        r100.followers = this.followers;
        r100.selfPermissionData = this.selfPermissionData;
        r100.dueTime = this.dueTime;
        r100.startMilliTime = this.startMilliTime;
        r100.displayCompletedMilliTime = this.displayCompletedMilliTime;
        r100.isAllDay = this.isAllDay;
        r100.dueTimeZone = this.dueTimeZone;
        r100.reminders = this.reminders;
        r100.creator = this.creator;
        r100.createMilliTime = this.createMilliTime;
        r100.deletedMilliTime = this.deletedMilliTime;
        r100.rrule = this.rrule;
        r100.progress = this.progress;
        r100.ancestorGuid = this.ancestorGuid;
        r100.mode = this.mode;
        r100.taskListGuids = this.taskListGuids;
        r100.attachments = this.attachments;
        r100.customFieldValues = this.customFieldValues;
        r100.isMileStone = this.isMileStone;
        r100.dependentRefs = this.dependentRefs;
        return r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public Todo parseToPb() {
        ArrayList r100 = new ArrayList();
        String r101 = this.referResourceId;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        Todo.Builder r102 = getPbData().newBuilder().guid(this.guid);
        TodoRichContent r103 = this.richDescription;
        RichContent r104 = null;
        if (r103 == null) goto L8;
        RichContent r105 = r103.parseToPb();
    L9:
        Todo.Builder r106 = r102.rich_description(r105).assignees(b.a(this.assignees)).completed_milli_time(Long.valueOf(this.completedMilliTime)).origin(this.origin).refer_resource_ids(r100).deleted_milli_time(Long.valueOf(this.deletedMilliTime)).source(this.source).creator_id(this.creatorId).followers(b.a(this.followers)).self_permission(this.selfPermissionData.parseToPb()).due_time(Long.valueOf(this.dueTime)).start_milli_time(Long.valueOf(this.startMilliTime)).display_completed_milli_time(this.displayCompletedMilliTime).is_all_day(Boolean.valueOf(this.isAllDay)).due_timezone(this.dueTimeZone).reminders(this.reminders).creator(this.creator).rrule(this.rrule).progress(this.progress).ancestor_guid(this.ancestorGuid).mode(this.mode).attachments(b.a(this.attachments)).custom_field_values(this.customFieldValues).is_milestone(Boolean.valueOf(this.isMileStone)).dependents(this.dependentRefs);
        if (this.summaryNeedTodBeUpdate == false) goto L16;
        TodoRichContent r107 = this.richSummary;
        if (r107 == null) goto L14;
        r104 = r107.parseToPb();
    L14:
        r106.rich_summary(r104);
    L16:
        return r106.build();
    L8:
        r105 = null;
        goto L9
    }

    /* JADX INFO: renamed from: getPbData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8686getPbData() {
        return getPbData();
    }

    public final String getAncestorGuid() {
        return this.ancestorGuid;
    }

    public final Map<String, SimpleTodo> getAncestors() {
        return this.ancestors;
    }

    public final List<TodoAssigneeData> getAssignees() {
        return this.assignees;
    }

    public final ArrayList<TodoAttachmentData> getAttachments() {
        return this.attachments;
    }

    public final long getCompletedMilliTime() {
        return this.completedMilliTime;
    }

    public final ArrayList<ContainerTaskFieldAssoc> getContainerFieldAssociations() {
        return this.containerFieldAssociations;
    }

    public final String getContainerGuid() {
        return this.containerGuid;
    }

    public final long getCreateMilliTime() {
        return this.createMilliTime;
    }

    public final boolean getCreateSuccess() {
        return this.createSuccess;
    }

    public final TodoUser getCreator() {
        return this.creator;
    }

    public final String getCreatorId() {
        return this.creatorId;
    }

    public final HashMap<String, TaskFieldValue> getCustomFieldValues() {
        return this.customFieldValues;
    }

    public final ArrayList<TodoAttachmentData> getDeletedAttachments() {
        return this.deletedAttachments;
    }

    public final long getDeletedMilliTime() {
        return this.deletedMilliTime;
    }

    public final ArrayList<TaskDependentRef> getDependentRefs() {
        return this.dependentRefs;
    }

    public final Long getDisplayCompletedMilliTime() {
        return this.displayCompletedMilliTime;
    }

    public final long getDueTime() {
        return this.dueTime;
    }

    public final String getDueTimeZone() {
        return this.dueTimeZone;
    }

    public final List<TodoFollowerData> getFollowers() {
        return this.followers;
    }

    public final String getGuid() {
        return this.guid;
    }

    public final TaskMode getMode() {
        return this.mode;
    }

    public final TodoOrigin getOrigin() {
        return this.origin;
    }

    public final String getOwnedContainerGuid() {
        return this.ownedContainerGuid;
    }

    public final String getOwnedRank() {
        return this.ownedRank;
    }

    public final String getOwnedSectionGuid() {
        return this.ownedSectionGuid;
    }

    public final ArrayList<TaskSection> getOwnedSections() {
        return this.ownedSections;
    }

    public final String getParentGuid() {
        return this.parentGuid;
    }

    public final RichContent getParentSummary() {
        return this.parentSummary;
    }

    public final Progress getProgress() {
        return this.progress;
    }

    public final String getRank() {
        return this.rank;
    }

    public final String getReferResourceId() {
        return this.referResourceId;
    }

    public final List<TodoReminder> getReminders() {
        return this.reminders;
    }

    public final TodoRichContent getRichDescription() {
        return this.richDescription;
    }

    public final TodoRichContent getRichSummary() {
        return this.richSummary;
    }

    public final String getRrule() {
        return this.rrule;
    }

    public final TodoSceneType getSceneType() {
        return this.sceneType;
    }

    public final String getSectionGuid() {
        return this.sectionGuid;
    }

    public final TodoItemPermissionData getSelfPermissionData() {
        return this.selfPermissionData;
    }

    public final TodoSource getSource() {
        return this.source;
    }

    public final long getStartMilliTime() {
        return this.startMilliTime;
    }

    public final boolean getSummaryNeedTodBeUpdate() {
        return this.summaryNeedTodBeUpdate;
    }

    public final HashMap<String, Todo> getTaskDependents() {
        return this.taskDependents;
    }

    public final ArrayList<String> getTaskListGuids() {
        return this.taskListGuids;
    }

    public final String getTrackEventName() {
        return this.trackEventName;
    }

    public final ArrayList<TodoAttachmentData> getUploadingAttachments() {
        return this.uploadingAttachments;
    }

    public final boolean isAllDay() {
        return this.isAllDay;
    }

    public final boolean isCreateFromMessage() {
        return this.isCreateFromMessage;
    }

    public final boolean isCreateFromMultiMessage() {
        return this.isCreateFromMultiMessage;
    }

    public final boolean isCreateTodo() {
        return this.isCreateTodo;
    }

    public final boolean isInFastCreate() {
        return this.isInFastCreate;
    }

    public final boolean isMileStone() {
        return this.isMileStone;
    }

    public final boolean isShouldFastCreate() {
        return this.isShouldFastCreate;
    }

    public final boolean isShouldUseDraft() {
        return this.isShouldUseDraft;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public boolean isValid() {
        return this.isValid;
    }

    public Todo getPbData() {
        return this.pbData;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public /* bridge */ /* synthetic */ Todo parseToPb() {
        return parseToPb();
    }

    public TodoData(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, "pbData");
        this.pbData = r100;
        this.isCreateTodo = true;
        this.guid = getPbData().guid;
        this.assignees = b.c(getPbData().assignees, TodoAssignee.class, TodoAssigneeData.class);
        this.referResourceId = (String) CollectionsKt.firstOrNull(getPbData().refer_resource_ids);
        this.completedMilliTime = getPbData().completed_milli_time.longValue();
        this.deletedMilliTime = getPbData().deleted_milli_time.longValue();
        this.source = getPbData().source;
        this.creatorId = getPbData().creator_id;
        this.followers = b.c(getPbData().followers, TodoFollower.class, TodoFollowerData.class);
        this.selfPermissionData = new TodoItemPermissionData(getPbData().self_permission);
        this.dueTime = getPbData().due_time.longValue();
        this.startMilliTime = getPbData().start_milli_time.longValue();
        this.displayCompletedMilliTime = getPbData().display_completed_milli_time;
        this.isAllDay = getPbData().is_all_day.booleanValue();
        this.dueTimeZone = getPbData().due_timezone;
        this.reminders = CollectionsKt.toMutableList(getPbData().reminders);
        this.creator = getPbData().creator;
        Long r101 = getPbData().create_milli_time;
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L6:
        this.createMilliTime = r102;
        boolean r103 = false;
        this.richSummary = new TodoRichContent(getPbData().rich_summary, r103, 2, null);
        this.richDescription = new TodoRichContent(getPbData().rich_description, true);
        this.progress = getPbData().progress;
        String r104 = getPbData().rrule;
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        this.rrule = r104;
        this.parentGuid = "";
        this.ancestorGuid = getPbData().ancestor_guid;
        this.ancestors = MapsKt.emptyMap();
        this.mode = getPbData().mode;
        ArrayList<String> r105 = new ArrayList();
        List<String> r106 = getPbData().related_task_list_guids;
        if (r106 == null) goto L12;
        r105.addAll(r106);
    L12:
        this.taskListGuids = r105;
        this.uploadingAttachments = new ArrayList();
        this.deletedAttachments = new ArrayList();
        this.attachments = new ArrayList(b.c(getPbData().attachments, TodoAttachment.class, TodoAttachmentData.class));
        this.customFieldValues = new HashMap(getPbData().custom_field_values);
        this.containerFieldAssociations = new ArrayList();
        this.isMileStone = getPbData().is_milestone.booleanValue();
        this.dependentRefs = new ArrayList(getPbData().dependents);
        this.taskDependents = new HashMap();
        this.isValid = true;
        this.trackEventName = "";
        this.rank = "";
        this.containerGuid = "";
        this.sectionGuid = "";
        this.ownedRank = "";
        this.ownedContainerGuid = "";
        this.ownedSectionGuid = "";
        this.ownedSections = new ArrayList();
        return;
    L5:
        r102 = System.currentTimeMillis();
        goto L6
    }

    public final void setAllDay(boolean r100) {
        this.isAllDay = r100;
    }

    public final void setAncestorGuid(String r100) {
        this.ancestorGuid = r100;
    }

    public final void setAncestors(Map<String, SimpleTodo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ancestors = r100;
    }

    public final void setAssignees(List<TodoAssigneeData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.assignees = r100;
    }

    public final void setAttachments(ArrayList<TodoAttachmentData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.attachments = r100;
    }

    public final void setCompletedMilliTime(long r100) {
        this.completedMilliTime = r100;
    }

    public final void setContainerFieldAssociations(ArrayList<ContainerTaskFieldAssoc> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.containerFieldAssociations = r100;
    }

    public final void setContainerGuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.containerGuid = r100;
    }

    public final void setCreateFromMessage(boolean r100) {
        this.isCreateFromMessage = r100;
    }

    public final void setCreateFromMultiMessage(boolean r100) {
        this.isCreateFromMultiMessage = r100;
    }

    public final void setCreateMilliTime(long r100) {
        this.createMilliTime = r100;
    }

    public final void setCreateSuccess(boolean r100) {
        this.createSuccess = r100;
    }

    public final void setCreateTodo(boolean r100) {
        this.isCreateTodo = r100;
    }

    public final void setCreator(TodoUser r100) {
        this.creator = r100;
    }

    public final void setCreatorId(String r100) {
        this.creatorId = r100;
    }

    public final void setCustomFieldValues(HashMap<String, TaskFieldValue> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.customFieldValues = r100;
    }

    public final void setDeletedAttachments(ArrayList<TodoAttachmentData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deletedAttachments = r100;
    }

    public final void setDeletedMilliTime(long r100) {
        this.deletedMilliTime = r100;
    }

    public final void setDependentRefs(ArrayList<TaskDependentRef> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dependentRefs = r100;
    }

    public final void setDisplayCompletedMilliTime(Long r100) {
        this.displayCompletedMilliTime = r100;
    }

    public final void setDueTime(long r100) {
        this.dueTime = r100;
    }

    public final void setDueTimeZone(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dueTimeZone = r100;
    }

    public final void setFollowers(List<TodoFollowerData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.followers = r100;
    }

    public final void setGuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.guid = r100;
    }

    public final void setInFastCreate(boolean r100) {
        this.isInFastCreate = r100;
    }

    public final void setMileStone(boolean r100) {
        this.isMileStone = r100;
    }

    public final void setMode(TaskMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mode = r100;
    }

    public final void setOrigin(TodoOrigin r100) {
        this.origin = r100;
    }

    public final void setOwnedContainerGuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ownedContainerGuid = r100;
    }

    public final void setOwnedRank(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ownedRank = r100;
    }

    public final void setOwnedSectionGuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ownedSectionGuid = r100;
    }

    public final void setOwnedSections(ArrayList<TaskSection> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ownedSections = r100;
    }

    public final void setParentGuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.parentGuid = r100;
    }

    public final void setParentSummary(RichContent r100) {
        this.parentSummary = r100;
    }

    public void setPbData(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pbData = r100;
    }

    public final void setProgress(Progress r100) {
        this.progress = r100;
    }

    public final void setRank(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rank = r100;
    }

    public final void setReferResourceId(String r100) {
        this.referResourceId = r100;
    }

    public final void setReminders(List<TodoReminder> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reminders = r100;
    }

    public final void setRichDescription(TodoRichContent r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.richDescription = r100;
    }

    public final void setRichSummary(TodoRichContent r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.richSummary = r100;
    }

    public final void setRrule(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rrule = r100;
    }

    public final void setSceneType(TodoSceneType r100) {
        this.sceneType = r100;
    }

    public final void setSectionGuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sectionGuid = r100;
    }

    public final void setSelfPermissionData(TodoItemPermissionData r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selfPermissionData = r100;
    }

    public final void setShouldFastCreate(boolean r100) {
        this.isShouldFastCreate = r100;
    }

    public final void setShouldUseDraft(boolean r100) {
        this.isShouldUseDraft = r100;
    }

    public final void setSource(TodoSource r100) {
        this.source = r100;
    }

    public final void setStartMilliTime(long r100) {
        this.startMilliTime = r100;
    }

    public final void setSummaryNeedTodBeUpdate(boolean r100) {
        this.summaryNeedTodBeUpdate = r100;
    }

    public final void setTaskDependents(HashMap<String, Todo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskDependents = r100;
    }

    public final void setTaskListGuids(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.taskListGuids = r100;
    }

    public final void setTrackEventName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.trackEventName = r100;
    }

    public final void setUploadingAttachments(ArrayList<TodoAttachmentData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uploadingAttachments = r100;
    }

    public void setValid(boolean r100) {
        this.isValid = r100;
    }

    public final void updateFromPbData(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, IOfflineExtraParser.ParserType.TODO);
        setPbData(r100);
        this.richSummary = new TodoRichContent(r100.rich_summary, false, 2, null);
        this.richDescription = new TodoRichContent(r100.rich_description, true);
        this.assignees = b.c(r100.assignees, TodoAssignee.class, TodoAssigneeData.class);
        Long r101 = r100.completed_milli_time;
        long r102 = 0;
        if (r101 == null) goto L5;
        long r103 = r101.longValue();
    L6:
        this.completedMilliTime = r103;
        this.referResourceId = (String) CollectionsKt.firstOrNull(r100.refer_resource_ids);
        this.source = r100.source;
        this.origin = r100.origin;
        this.creatorId = r100.creator_id;
        this.followers = b.c(r100.followers, TodoFollower.class, TodoFollowerData.class);
        this.selfPermissionData = new TodoItemPermissionData(getPbData().self_permission);
        Long r104 = r100.due_time;
        if (r104 == null) goto L9;
        long r105 = r104.longValue();
    L10:
        this.dueTime = r105;
        Long r106 = r100.start_milli_time;
        if (r106 == null) goto L13;
        long r107 = r106.longValue();
    L14:
        this.startMilliTime = r107;
        this.displayCompletedMilliTime = r100.display_completed_milli_time;
        this.isAllDay = r100.is_all_day.booleanValue();
        String r108 = r100.due_timezone;
        if (r108 != null) goto L17;
        r108 = TimeZone.getDefault().getID();
    L17:
        this.dueTimeZone = r108;
        this.reminders = CollectionsKt.toMutableList(r100.reminders);
        this.creator = r100.creator;
        Long r109 = r100.create_milli_time;
        if (r109 == null) goto L20;
        long r110 = r109.longValue();
    L21:
        this.createMilliTime = r110;
        Long r111 = r100.deleted_milli_time;
        if (r111 == null) goto L24;
        r102 = r111.longValue();
    L24:
        this.deletedMilliTime = r102;
        String r112 = r100.rrule;
        if (r112 != null) goto L27;
        r112 = "";
    L27:
        this.rrule = r112;
        this.progress = r100.progress;
        this.ancestorGuid = r100.ancestor_guid;
        this.mode = r100.mode;
        ArrayList<String> r113 = new ArrayList();
        List<String> r114 = getPbData().related_task_list_guids;
        if (r114 == null) goto L30;
        r113.addAll(r114);
    L30:
        this.taskListGuids = r113;
        this.attachments = new ArrayList(b.c(r100.attachments, TodoAttachment.class, TodoAttachmentData.class));
        this.customFieldValues = new HashMap(r100.custom_field_values);
        this.isMileStone = r100.is_milestone.booleanValue();
        this.dependentRefs = new ArrayList(r100.dependents);
        return;
    L20:
        r110 = System.currentTimeMillis();
        goto L21
    L13:
        r107 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final void updateFromSimpleTodo(SimpleSubTodoData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.guid = UUID.randomUUID().toString();
        this.richSummary = r100.getSummary();
        this.richDescription = r100.getDescription();
        this.dueTime = r100.getDueTimeMillis() / ((long) 1000);
        this.startMilliTime = r100.getStartTimeMillis();
        this.isAllDay = r100.isAllDay();
        this.reminders = r100.getReminders();
        this.rrule = r100.getRrule();
        this.creatorId = r100.getCreatorId();
        this.assignees = b.c(r100.getAssignees(), TodoAssignee.class, TodoAssigneeData.class);
        this.followers = b.c(r100.getFollowers(), TodoFollower.class, TodoFollowerData.class);
        this.mode = r100.getMode();
        this.attachments = new ArrayList(b.c(r100.getAttachments(), TodoAttachment.class, TodoAttachmentData.class));
        this.isMileStone = r100.isMileStone();
        this.dependentRefs = r100.getDependentRefs();
    }

    public final void updateFromTodoData(TodoData r100) {
        Intrinsics.checkNotNullParameter(r100, IOfflineExtraParser.ParserType.TODO);
        this.richSummary = r100.richSummary;
        this.richDescription = r100.richDescription;
        this.assignees = r100.assignees;
        this.completedMilliTime = r100.completedMilliTime;
        this.referResourceId = r100.referResourceId;
        this.source = r100.source;
        this.origin = r100.origin;
        this.creatorId = r100.creatorId;
        this.followers = r100.followers;
        this.selfPermissionData = r100.selfPermissionData;
        this.dueTime = r100.dueTime;
        this.startMilliTime = r100.startMilliTime;
        this.displayCompletedMilliTime = r100.displayCompletedMilliTime;
        this.isAllDay = r100.isAllDay;
        this.dueTimeZone = r100.dueTimeZone;
        this.reminders = r100.reminders;
        this.creator = r100.creator;
        this.createMilliTime = r100.createMilliTime;
        this.deletedMilliTime = r100.deletedMilliTime;
        this.rrule = r100.rrule;
        this.progress = r100.progress;
        this.ancestorGuid = r100.ancestorGuid;
        this.mode = r100.mode;
        this.taskListGuids = r100.taskListGuids;
        this.attachments = r100.attachments;
        this.customFieldValues = r100.customFieldValues;
        this.isMileStone = r100.isMileStone;
        this.dependentRefs = r100.dependentRefs;
    }

    public /* bridge */ /* synthetic */ void setPbData(Object r100) {
        setPbData((Todo) r100);
    }
}
