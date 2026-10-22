package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.bytedance.ee.bear.middleground.comment.export.commentsdk.bean.DiffComments;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DataEntity implements BaseJSModel {
    private String business;
    private Entity data;

    public static class Entity implements BaseJSModel {
        private BodyEntity body;
        private HeaderEntity header;
        private IdentifierEntity identifier;
        private String operation;

        public static class BodyEntity implements BaseJSModel {
            private int code;
            private String data;
            private Extra extra;
            private String msg;

            public static class Extra implements BaseJSModel {
                private String notNotifyUsers;

                public Extra() {
                }

                public String getNotNotifyUsers() {
                    return this.notNotifyUsers;
                }

                public void setNotNotifyUsers(String r1) {
                    this.notNotifyUsers = r1;
                }
            }

            public static class PublishEntity implements BaseJSModel {
                private Comment comment;
                private boolean isNewComment;
                private String localCommentId;

                public static class Comment implements BaseJSModel {
                    private String commentId;

                    public Comment() {
                    }

                    public String getCommentId() {
                        return this.commentId;
                    }

                    public void setCommentId(String r1) {
                        this.commentId = r1;
                    }
                }

                public PublishEntity() {
                }

                public Comment getComment() {
                    return this.comment;
                }

                public String getLocalCommentId() {
                    return this.localCommentId;
                }

                public boolean isNewComment() {
                    return this.isNewComment;
                }

                public void setComment(Comment r1) {
                    this.comment = r1;
                }

                public void setLocalCommentId(String r1) {
                    this.localCommentId = r1;
                }

                public void setNewComment(boolean r1) {
                    this.isNewComment = r1;
                }
            }

            public static class QueryCommentData implements BaseJSModel {
                private String commentId;
                private boolean noPermission;

                public QueryCommentData() {
                }

                public String getCommentId() {
                    return this.commentId;
                }

                public boolean isNoPermission() {
                    return this.noPermission;
                }

                public void setCommentId(String r1) {
                    this.commentId = r1;
                }

                public void setNoPermission(boolean r1) {
                    this.noPermission = r1;
                }
            }

            public static class ResultEntity implements BaseJSModel {
                private Comments allComments;
                private CommentBean comment;
                private DiffComments diffComments;

                public static class Comments implements BaseJSModel {
                    private List<CommentBean> comments;
                    private List<CommentBean> finishComments;

                    public Comments() {
                    }

                    public List<CommentBean> getComments() {
                        return this.comments;
                    }

                    public List<CommentBean> getFinishComments() {
                        return this.finishComments;
                    }

                    public void setComments(List<CommentBean> r1) {
                        this.comments = r1;
                    }

                    public void setFinishComments(List<CommentBean> r1) {
                        this.finishComments = r1;
                    }
                }

                public ResultEntity() {
                }

                public Comments getAllComments() {
                    return this.allComments;
                }

                public CommentBean getComment() {
                    return this.comment;
                }

                public DiffComments getDiffComments() {
                    return this.diffComments;
                }

                public void setAllComments(Comments r1) {
                    this.allComments = r1;
                }

                public void setComment(CommentBean r1) {
                    this.comment = r1;
                }

                public void setDiffComments(DiffComments r1) {
                    this.diffComments = r1;
                }
            }

            public BodyEntity() {
            }

            public int getCode() {
                return this.code;
            }

            public String getData() {
                return this.data;
            }

            public Extra getExtra() {
                return this.extra;
            }

            public String getMsg() {
                return this.msg;
            }

            public void setCode(int r1) {
                this.code = r1;
            }

            public void setData(String r1) {
                this.data = r1;
            }

            public void setExtra(Extra r1) {
                this.extra = r1;
            }

            public void setMsg(String r1) {
                this.msg = r1;
            }
        }

        public static class HeaderEntity implements BaseJSModel {
            private String requestId;

            public HeaderEntity() {
            }

            public String getRequestId() {
                return this.requestId;
            }

            public void setRequestId(String r1) {
                this.requestId = r1;
            }
        }

        public static class IdentifierEntity implements BaseJSModel {
            private String token;
            private int type;

            public IdentifierEntity() {
            }

            public String getToken() {
                return this.token;
            }

            public int getType() {
                return this.type;
            }

            public void setToken(String r1) {
                this.token = r1;
            }

            public void setType(int r1) {
                this.type = r1;
            }
        }

        public Entity() {
        }

        public BodyEntity getBody() {
            return this.body;
        }

        public HeaderEntity getHeader() {
            return this.header;
        }

        public IdentifierEntity getIdentifier() {
            return this.identifier;
        }

        public String getOperation() {
            return this.operation;
        }

        public void setBody(BodyEntity r1) {
            this.body = r1;
        }

        public void setHeader(HeaderEntity r1) {
            this.header = r1;
        }

        public void setIdentifier(IdentifierEntity r1) {
            this.identifier = r1;
        }

        public void setOperation(String r1) {
            this.operation = r1;
        }
    }

    public DataEntity() {
    }

    public String getBusiness() {
        return this.business;
    }

    public Entity getData() {
        return this.data;
    }

    public void setBusiness(String r1) {
        this.business = r1;
    }

    public void setData(Entity r1) {
        this.data = r1;
    }
}
